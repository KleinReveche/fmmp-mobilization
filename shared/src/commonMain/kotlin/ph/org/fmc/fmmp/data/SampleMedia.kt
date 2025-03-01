package ph.org.fmc.fmmp.data

import ph.org.fmc.fmmp.domain.models.MediaInfo
import ph.org.fmc.fmmp.domain.models.MediaType

object SampleMedia {
    val mediaList = listOf(
        MediaInfo(
            id = "0",
            title = "Mobilization Monday | Debut Episode (Ep. 1) | February 3, 2025",
            description = """We're kicking off Mobilization Monday with a powerful conversation featuring Bishop Tereso Lanzon Jr. as we dive deep into Tinguha 2026—our collective mission to expand God's work in the Philippines and beyond! 🇵🇭🔥""",
            mediaType = MediaType.YOUTUBE,
            thumbnailUrl = "https://img.youtube.com/vi/Y7i23stJ_38/maxresdefault.jpg",
            mediaUrl = "https://www.youtube.com/watch?v=Y7i23stJ_38"
        ),
        MediaInfo(
            id = "1",
            title = "FMMP NEAP Gathering 2025 Highlights",
            description = "Praise God for the FMMP Execom and CMDs who gathered for two impactful days of reflection, prayer, and planning. Bishop Tereso Lanzon Jr. reminded us to focus on faithful stewardship, prioritizing our identity in Christ over our actions. We also envisioned the future of the Church by 2050, considering how we can faithfully proclaim the Gospel to future generations.",
            mediaType = MediaType.YOUTUBE,
            thumbnailUrl = "https://img.youtube.com/vi/yY2yD7ITSzA/maxresdefault.jpg",
            mediaUrl = "https://www.youtube.com/watch?v=yY2yD7ITSzA"
        ),
        MediaInfo(
            id = "2",
            title = "Mobilization Monday | Episode 2 - February 17, 2025",
            description = """
                ✨ FREEPH Accomplishments, Ministry Goals & the Season of Waiting | ft. Ms. Kanaku Nishimura ✨

                Join us as we sit down with Ms. Kanaku Nishimura to reflect on the incredible accomplishments of FREEPH and the exciting ministry goals ahead! 🙌🌏 Together, we explore what it means to have the right attitude in the season of waiting—trusting God’s timing while faithfully serving. 💛
            """.trimIndent(),
            mediaType = MediaType.YOUTUBE,
            thumbnailUrl = "https://img.youtube.com/vi/zRIFrhZtZiI/maxresdefault.jpg",
            mediaUrl = "https://www.youtube.com/watch?v=zRIFrhZtZiI"
        ),
        MediaInfo(
            id = "3",
            title = "Mobilization Monday | Episode 3 - February 24, 2025",
            description = """
                Mobilization Monday is back! This week, we’re featuring Ms. Chinky of International Child Care Ministries Philippines as she shares how child sponsorship transforms lives and opens doors for missions. Be inspired to make a difference in the next generation! 🙌💙
                 """.trimIndent(),
            mediaType = MediaType.YOUTUBE,
            thumbnailUrl = "https://img.youtube.com/vi/88Te-JuUIJE/maxresdefault.jpg",
            mediaUrl = "https://www.youtube.com/watch?v=88Te-JuUIJE"
        ),
    )
}