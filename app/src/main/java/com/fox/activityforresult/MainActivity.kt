package com.fox.activityforresult

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.fox.activityforresult.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    val mStartForResult = registerForActivityResult (StartActivityForResult(),
        ActivityResultCallback {
            println(it)
                    if (it.resultCode === 2) {

            val message: String? = it?.data?.getStringExtra("MESSAGE")

            binding.ac1Tv.setText(message)
                    }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ac1Btn.setOnClickListener {
            var myIntent = Intent(this, Activity2::class.java)

            mStartForResult.launch(myIntent)
//            startActivityForResult(myIntent, 2)


        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode === 2) {
//
//            val message: String? = data?.getStringExtra("MESSAGE")
//
//            binding.ac1Tv.setText(message)
//        }
//    }
}