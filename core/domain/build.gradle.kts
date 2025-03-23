plugins {
    alias(libs.plugins.fma.domainModule)
    alias(libs.plugins.kotlin.parcelize)
}

kotlin {
    sourceSets {
        androidTarget {
            compilerOptions {
                freeCompilerArgs.addAll(
                    "-P",
                    "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=ph.org.fmc.fmmp.core.domain.Parcelize"
                )
            }
        }

        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
        }

        wasmJsMain.dependencies {
            implementation(libs.kotlinx.browser)
        }
    }
}