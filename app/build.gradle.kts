import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import java.io.FileInputStream
import java.util.Properties

val versionProperties = Properties().apply { load(FileInputStream("$rootDir/versions.properties")) }
val versionMajor = versionProperties.getProperty("versionMajor").toInt()
val versionMinor = versionProperties.getProperty("versionMinor").toInt()
val versionPatch = versionProperties.getProperty("versionPatch").toInt()
val appVersionCode = versionMajor * 10000 + versionMinor * 100 + versionPatch
val appVersionName = "$versionMajor.$versionMinor.$versionPatch"

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.buildConfig)
    alias(libs.plugins.compose.hotReload)
}

kotlin {
    jvmToolchain(17)

    androidTarget()

    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName = "fmmp-mobilization"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "fmmp-mobilization.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.data)
            implementation(projects.core.domain)
            implementation(projects.core.ui)

            implementation(projects.feature.home)
            implementation(projects.feature.media)
            implementation(projects.feature.plans)
            implementation(projects.feature.updates)
            implementation(projects.feature.settings)

            implementation(libs.bundles.kotlin)

            implementation(libs.kermit)
        }
    }
}

android {
    namespace = "ph.org.fmc.fmmp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()

        applicationId = "ph.org.fmc.fmmp"
        versionCode = appVersionCode
        versionName = appVersionName
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "fmmp-mobilization"
            packageVersion = "1.0.0"

            linux {
                iconFile.set(project.file("commonMain/icons/fmmp.png"))
            }
            windows {
                iconFile.set(project.file("commonMain/icons/fmmp.ico"))
            }
            macOS {
                iconFile.set(project.file("commonMain/cons/fmmp.icns"))
                bundleID = "ph.org.fmc.fmmp.desktopApp"
                dmgPackageVersion =
                    if (versionMajor > 0) appVersionName else "1.${appVersionName.removePrefix("0.")}"
            }
        }
    }
}


composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    metricsDestination = layout.buildDirectory.dir("compose_compiler")
    featureFlags.add(ComposeFeatureFlag.OptimizeNonSkippingGroups)
}

buildConfig {
    // BuildConfig configuration here.
    // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
    packageName("ph.org.fmc.fmmp")
    useKotlinOutput { internalVisibility = false }

    buildConfigField<String>("APP_VERSION", appVersionName)

    forClass(packageName = "ph.org.fmc.fmmp", className = "Constants") {
        buildConfigField<String>("PGC_FB_PAGE", "https://www.facebook.com/pgcfmcofficial")
        buildConfigField<String>("FMMP_FB_PAGE", "https://www.facebook.com/FMMPOfficial")
    }
}