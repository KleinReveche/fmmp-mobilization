plugins {
    alias(libs.plugins.fma.featureModule)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.ui)
        }
    }
}