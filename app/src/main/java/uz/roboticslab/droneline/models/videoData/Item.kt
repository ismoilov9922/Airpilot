package uz.roboticslab.droneline.models.videoData

data class Item(
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet,
    val statistics: Statistics
)