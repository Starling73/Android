package com.example.lab1

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes

abstract class BaseActivity : AppCompatActivity() {

    var pref: SharedPreferences? = null
//    var string = ""
    val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.la)
    }

//    protected abstract val getLayoutId: Int
}
