package com.foxxx.activityforresultapiapp

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.foxxx.activityforresultapiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contractUsername = ActivityResultContracts.StartActivityForResult()
        val launcherUsername = registerForActivityResult(contractUsername) {
            if (it.resultCode == RESULT_OK) {
                binding.usernameTextview.text =
                    it.data?.getStringExtra(UsernameActivity.EXTRA_USERNAME)
            }
        }

        val contractImage = ActivityResultContracts.GetContent()
        val launcherImage = registerForActivityResult(contractImage) {
            binding.imageFromGalleryImageview.setImageURI(it)
        }

        binding.getUsernameButton.setOnClickListener {
            launcherUsername.launch(UsernameActivity.newIntent(this))
        }

        binding.getImageButton.setOnClickListener {
            launcherImage.launch("image/*")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}