package uz.roboticslab.droneline.models.videoData

data class VideoData(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo
)