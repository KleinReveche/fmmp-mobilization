@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package ph.org.fmc.fmmp.data

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
// No `expect` keyword here
annotation class FmaParcelize()

expect interface FmaParcelable

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
expect annotation class MyIgnoredOnParcel()

@FmaParcelize
class MyClass(
    val x: String,
    @MyIgnoredOnParcel val y: String = ""
): FmaParcelable
