plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("multiplatform") {
            id = libs.plugins.fma.multiplatform.get().pluginId
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }

        register("androidLibrary") {
            id = libs.plugins.fma.androidLibrary.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("domainModule") {
            id = libs.plugins.fma.domainModule.get().pluginId
            implementationClass = "DomainModuleConventionPlugin"
        }

        register("dataModule") {
            id = libs.plugins.fma.dataModule.get().pluginId
            implementationClass = "DataModuleConventionPlugin"
        }

        register("featureModule") {
            id = libs.plugins.fma.featureModule.get().pluginId
            implementationClass = "FeatureModuleConventionPlugin"
        }
    }
}