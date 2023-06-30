package uz.roboticslab.droneline.ui.drone_learn.create_drone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uz.roboticslab.droneline.models.videoData.VideoData
import uz.roboticslab.droneline.repositary.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.roboticslab.droneline.utils.NetworkHelper
import uz.roboticslab.droneline.utils.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LearnViewModel @Inject constructor(private val networkRepository: NetworkRepository) :
    ViewModel() {

    private val _videoList = MutableLiveData<Resource<VideoData>>()
    val loggingList: LiveData<Resource<VideoData>> get() = _videoList
    fun getYoutubeVideo(videoId: String) {
        NetworkHelper().check {
            if (it) {
                _videoList.postValue(Resource.loading(null))
                viewModelScope.launch {
                    try {
                        coroutineScope {
                            networkRepository.getVideo(videoId).let {
                                _videoList.postValue(Resource.success(it))
                            }
                        }
                    } catch (e: Exception) {
                        _videoList.postValue(Resource.error(e.message.toString(), null))
                    }
                }
            } else {
                _videoList.postValue(Resource.error("No internet connection", null))
            }
        }
    }

}