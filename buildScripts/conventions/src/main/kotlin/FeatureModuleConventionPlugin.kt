import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()
        plugins.apply(libs.findPlugin("fma.multiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("fma.androidLibrary").get().get().pluginId)
        plugins.apply(libs.findPlugin("multiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("compose").get().get().pluginId)
        plugins.apply(libs.findPlugin("compose.compiler").get().get().pluginId)
        plugins.apply(libs.findPlugin("kotlinx.serialization").get().get().pluginId)

        extensions.configure<KotlinMultiplatformExtension> {
            androidTarget {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }

            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {
                        implementation(libs.findLibrary("kotlinx.serialization.json").get().get())
                        libs.findBundle("koin.compose").get().get().forEach {
                            implementation(it)
                        }
                    }
                }
            }
        }
    }
}