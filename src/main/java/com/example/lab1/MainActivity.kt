package com.example.lab1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    var string = ""
    private lateinit var roger: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)


        openFrag(R.id.place_holder, BlankFragment.newInstance())
        openFrag(R.id.place_holder2, BlankFragment2.newInstance())

    }


    fun saveData(res: String) {
        val editor = pref?.edit()
        editor?.putString("faculty", res)
        editor?.apply()
    }

    fun openNewActivity(view: android.view.View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        string = dataModel.message.value.toString()
        saveData(string)
        startActivity(intent)
    }

    private fun openFrag(idHolder: Int, f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }


}
