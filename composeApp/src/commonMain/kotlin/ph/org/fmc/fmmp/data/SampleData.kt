package ph.org.fmc.fmmp.data

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ph.org.fmc.fmmp.domain.models.MediaInfo
import ph.org.fmc.fmmp.domain.models.NewsUpdate
import ph.org.fmc.fmmp.resources.Res

@OptIn(ExperimentalResourceApi::class)
suspend fun getSampleMediaList() : List<MediaInfo> {
    val bytes = Res.readBytes("files/sampleMediaInfo.json")
    return Json.decodeFromString(ListSerializer(MediaInfo.serializer()), bytes.decodeToString()).reversed()
}

@OptIn(ExperimentalResourceApi::class)
suspend fun getSampleUpdatesList() : List<NewsUpdate> {
    val bytes = Res.readBytes("files/sampleUpdates.json")
    return Json.decodeFromString(ListSerializer(NewsUpdate.serializer()), bytes.decodeToString())
}