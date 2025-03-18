import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class DataModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()
        plugins.apply(libs.findPlugin("fma.multiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("kotlinx.serialization").get().get().pluginId)

        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {
                        implementation(libs.findLibrary("kotlinx.serialization.json").get().get())
                        implementation(libs.findLibrary("kotlinx.datetime").get().get())
                    }
                }
            }
        }
    }
}