package com.example.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.User
import com.example.mvvm.repository.UserRepository

class UserViewModel() : ViewModel() {
    private val userRepository: UserRepository = UserRepository()
    val liveDataUser : MutableLiveData<ArrayList<User>> = userRepository.getLiveDataUser()
    val singleUser : MutableLiveData<User> = MutableLiveData()

    fun addUser(user : User){
        singleUser.value = user
    }
}
