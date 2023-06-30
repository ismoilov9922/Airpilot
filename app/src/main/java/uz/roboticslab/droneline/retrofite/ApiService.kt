package uz.roboticslab.droneline.retrofite

import android.provider.Contacts.SettingsColumns.KEY
import uz.roboticslab.droneline.models.videoData.VideoData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    @GET("playlists")
//    suspend fun getPlaylistVideo(
//        @Query("key") key: String = Const.KEY,
//        @Query("part") part: String = "snippet,contentDetails",
//        @Query("channelId") channelId: String = "UCr0y1P0-zH2o3cFJyBSfAKg",
//        @Query("maxResults") maxResults: Int = 50,
//    ): YoutubePlaylist

//    @GET("search")
//    suspend fun getSearch(
//        @Query("key") key: String = Const.KEY,
//        @Query("part") part: String = "snippet",
//        @Query("q") q: String = "android",
//        @Query("type") type: String = "video",
//        @Query("maxResults") maxResults: Int = 50,
//    ): SearchVideo

    @GET("videos")
    suspend fun getVideoData(
        @Query("key") key: String = KEY,
        @Query("id") id: String = "tIjt9hhcdRQ",
        @Query("part") part: String = "snippet,statistics",
    ): VideoData

//    @GET("commentThreads")
//    suspend fun getComment(
//        @Query("key") key: String = Const.KEY,
//        @Query("videoId") id: String = "tIjt9hhcdRQ",
//        @Query("part") part: String = "snippet",
//        @Query("snippet.topLevelComment.snippet.textOriginal") comment: String = "",
//    ): GetComment

}