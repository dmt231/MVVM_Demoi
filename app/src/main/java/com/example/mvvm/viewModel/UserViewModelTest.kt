package com.example.mvvm.viewModel

import com.example.mvvm.model.User

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.assertEquals

@RunWith(JUnit4::class)
class UserViewModelTest {

    private lateinit var viewModel : UserViewModel

    @Before
    fun setUp(){
        viewModel = UserViewModel()
    }

    @Test
    fun addUser(){
        val user = User()
        user.setUsername("New User")
        viewModel.addUser(user)
        assertEquals(user, viewModel.singleUser.value)
    }
}