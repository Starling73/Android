package com.example.lab1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.example.lab1.databinding.ActivityMainBinding
import com.example.lab1.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity() {
    lateinit var binding: ActivitySecondBinding
    var string = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        string = pref?.getString("faculty", "Ничего не выбрано")!!
        binding.textView4.text = string


    }


    fun OnClickButton(view: android.view.View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }
}
