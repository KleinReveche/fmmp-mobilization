package ph.org.fmc.fmmp.core.domain.models

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.core.domain.Parcelable
import ph.org.fmc.fmmp.core.domain.Parcelize
import kotlin.time.Duration.Companion.days

@Parcelize
@Serializable
data class NewsUpdate(
    val id: Int,
    val title: String,
    val summary: String,
    val content: String,
    val publishedAt: Long,
    val authorName: String,
    val authorImage: String
) : Parcelable {
    fun getFormattedPublishDate(monthNames: List<String>): String {
        val now = Clock.System.now()
        val publishedAtDate = Instant.fromEpochSeconds(publishedAt)
        val diff = now - publishedAtDate

        return when {
            diff < 1.days -> "Today"
            diff < 2.days -> "Yesterday"
            diff < 7.days -> "${diff.inWholeDays} days ago"
            diff < 30.days -> "${diff.inWholeDays / 7} weeks ago"
            else -> {
                val localDate = publishedAtDate.toLocalDateTime(TimeZone.currentSystemDefault())
                val month = monthNames[localDate.month.number - 1]
                "$month ${localDate.dayOfMonth}, ${localDate.year}"
            }
        }
    }
}