import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.fma.featureModule)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            api(compose.preview)
            api(libs.androidx.activity.compose)

            api(libs.ktor.client.okhttp)
        }
        commonMain.dependencies {
            api(projects.core.data)
            api(projects.core.domain)

            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(compose.ui)
            api(compose.components.resources)
            api(compose.components.uiToolingPreview)
            api(compose.materialIconsExtended)

            @OptIn(ExperimentalComposeLibrary::class)
            api(compose.uiTest)

            api(libs.koin.core)
            api(libs.bundles.koin.compose)

            api(libs.androidx.navigation.compose)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtime.compose)

            api(libs.material3.adaptive.navigation)
            api(libs.material3.adaptive.navigation.suite)
            api(libs.material3.adaptive.layout)

            implementation(libs.coil.compose)
            implementation(libs.coil.compose.core)
            implementation(libs.coil.network.ktor)

            api(libs.markdown.m3)
            api(libs.markdown.coil3)

            api(libs.kotlinx.datetime)
        }

        jvmMain.dependencies {
            api(compose.desktop.currentOs)
            api(libs.kotlinx.coroutines.swing)
            api(libs.ktor.client.okhttp)
        }

        wasmJsMain.dependencies {
            api(libs.ktor.client.js)
        }
    }
}

dependencies {
    debugApi(compose.uiTooling)
}

compose.resources {
    publicResClass = true
    packageOfResClass = "ph.org.fmc.fmmp.core.ui.resources"
    generateResClass = always
}