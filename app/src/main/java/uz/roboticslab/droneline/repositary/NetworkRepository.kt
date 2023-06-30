package uz.roboticslab.droneline.repositary

import uz.roboticslab.droneline.retrofite.ApiService
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiService: ApiService) {
    /** get youtube video **/
    suspend fun getVideo(videoId: String) = apiService.getVideoData(id = videoId)
}