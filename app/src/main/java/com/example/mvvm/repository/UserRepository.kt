package com.example.mvvm.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.model.User
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository {
    var fireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
    fun getLiveDataUser() : MutableLiveData<ArrayList<User>>{
        val liveData : MutableLiveData<ArrayList<User>> = MutableLiveData()
        val collectionRef = fireStore.collection("User")
        collectionRef.orderBy("userId")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful && !it.result.isEmpty) {
                    val listUser = ArrayList<User>()
                    for (document in it.result) {
                        val name = document.getString("Name")
                        val image = document.getString("Image")
                        val id = document.getLong("userId")
                        val user = User(id!!, name!!, image!!)
                        listUser.add(user)
                    }
                    liveData.value = listUser
                } else {
                    Log.d("Error : ", "Not found any user")
                }
            }
        return liveData
    }
    fun getArrayListUser() : ArrayList<User>{
        val listUser = ArrayList<User>()
        val collectionRef = fireStore.collection("User")
        collectionRef.orderBy("userId")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful && !it.result.isEmpty) {
                    val listUser = ArrayList<User>()
                    for (document in it.result) {
                        val name = document.getString("Name")
                        val image = document.getString("Image")
                        val id = document.getLong("userId")
                        val user = User(id!!, name!!, image!!)
                        listUser.add(user)
                    }
                } else {
                    Log.d("Error : ", "Not found any user")
                }
            }
        return listUser
    }
}