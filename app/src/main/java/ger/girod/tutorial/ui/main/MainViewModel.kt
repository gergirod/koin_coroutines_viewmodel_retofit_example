package ger.girod.tutorial.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ger.girod.tutorial.domain.responses.UserListResponse
import ger.girod.tutorial.domain.use_cases.GetUsersUseCase
import ger.girod.tutorial.domain.utils.ResultWrapper
import ger.girod.tutorial.ui.utils.ScreenState
import kotlinx.coroutines.launch

class MainViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    var userListData : MutableLiveData<UserListResponse> = MutableLiveData()
    var screenStateData : MutableLiveData<ScreenState> = MutableLiveData()
    var loadMoreData : MutableLiveData<UserListResponse> = MutableLiveData()
    var errorMessage : MutableLiveData<String> = MutableLiveData()

    fun getInitialUserList() {
        viewModelScope.launch {
            screenStateData.postValue(ScreenState.Loading)
            when(val response = getUsersUseCase.getUsers(1,  10)) {
                is ResultWrapper.Success -> userListData.postValue(response.value)
                is ResultWrapper.GenericError -> "Oops! Something went wrong!"
                is ResultWrapper.NetworkError -> "No Internet Connection, try again later"
            }

            screenStateData.postValue(ScreenState.LoadingFinsh)
        }
    }

    fun loadMore(page : Int) {
        viewModelScope.launch {
            when(val response = getUsersUseCase.getUsers(page, 10)) {
                is ResultWrapper.Success -> loadMoreData.postValue(response.value)
                is ResultWrapper.GenericError ->  "Oops! Something went wrong!"
                is ResultWrapper.NetworkError -> "No Internet Connection, try again later"
            }
        }
    }

}
