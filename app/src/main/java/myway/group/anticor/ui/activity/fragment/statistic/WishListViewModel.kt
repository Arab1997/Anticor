package myway.group.anticor.ui.activity.fragment.statistic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.launch
import myway.group.anticor.ui.activity.repository.MyRepository

import java.lang.Exception

class WishListViewModel(private val repository: MyRepository) : ViewModel() {

   /* private val _wishList = MutableLiveData<Resource<List<Course>>>()
    val wishList: LiveData<Resource<List<Course>>> = _wishList

    init {
        getAllCourses()
    }

    fun getAllCourses() = viewModelScope.launch {
        _wishList.postValue(Resource.Loading())
        try {
            val list = repository.getAllWishCourses()
            list?.let {
                _wishList.postValue(Resource.Success(list))
            } ?: kotlin.run {
                _wishList.postValue(Resource.Error("Error"))
            }
        } catch (e: Exception) {
            _wishList.postValue(Resource.Error(e.message.toString()))
        }
    }

    fun deleteCourse(course: Course) = viewModelScope.launch {
        try {
            repository.deleteCourse(course)
        } catch (e: Exception) {
        }
    }

    fun addCourse(course: Course) = viewModelScope.launch {
        try {
            repository.addCourse(course)
        } catch (e: Exception) {
        }
    }*/
}