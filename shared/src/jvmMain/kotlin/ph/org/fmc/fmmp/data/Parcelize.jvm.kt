@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package ph.org.fmc.fmmp.data

actual interface FmaParcelable

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
actual annotation class MyIgnoredOnParcel actual constructor()