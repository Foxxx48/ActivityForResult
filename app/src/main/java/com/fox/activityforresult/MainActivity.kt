package com.fox.activityforresult

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fox.activityforresult.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getUsernameButton.setOnClickListener {
            UsernameActivity.newIntent(this).apply {
                startActivityForResult(this, RC_USERNAME)
            }

        }

            binding.getImageButton.setOnClickListener {
            Intent(Intent.ACTION_PICK).apply {
                type = "image/*" // MIME types
                startActivityForResult(this, RC_IMAGE)
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_USERNAME && resultCode == RESULT_OK) {
            val username = data?.getStringExtra(UsernameActivity.EXTRA_USERNAME) ?: ""
            binding.usernameTextview.text = username
        }
        if (requestCode == RC_IMAGE && resultCode == RESULT_OK) {
            val uri = data?.data
            binding.imageFromGalleryImageview.setImageURI(uri)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        private const val RC_USERNAME = 100
        private const val RC_IMAGE = 101
    }
}