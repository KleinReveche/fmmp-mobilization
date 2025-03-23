plugins {
    alias(libs.plugins.fma.dataModule)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.domain)
        }
    }
}