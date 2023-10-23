package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceLayout()
        setContentView(R.layout.activity_main)
    }
    private fun replaceLayout(){
        val mainFragment = MainFragment()
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.mainActivity, mainFragment)
        fragmentTrans.commit()
    }
}