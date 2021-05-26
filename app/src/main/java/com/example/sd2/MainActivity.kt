package com.example.sd2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.network.viewmodel.CustomViewModel
import com.example.sd2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val model: CustomViewModel by viewModels()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().disallowAddToBackStack()
                .add(R.id.container, MainFragment())
                .commitNow()
        }

    }
}