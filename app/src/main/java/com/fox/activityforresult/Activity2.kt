package com.fox.activityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.activityforresult.databinding.Activity2Binding
import com.fox.activityforresult.databinding.ActivityMainBinding

class Activity2 : AppCompatActivity() {
    private var _binding : Activity2Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ac2Btn.setOnClickListener {

            var message = binding.ac2Et.text.toString()
            var myIntent = Intent()
            myIntent.putExtra("MESSAGE", message)
            setResult(2,myIntent)
            finish()
        }
    }
}