package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        openFrag(R.id.place_holder, BlankFragment.newInstance())
        openFrag(R.id.place_holder2, BlankFragment2.newInstance())


    }

    private fun openFrag(idHolder: Int, f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}