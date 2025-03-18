@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package ph.org.fmc.fmmp.core.domain

actual interface Parcelable

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.PROPERTY)
actual annotation class IgnoredOnParcel()