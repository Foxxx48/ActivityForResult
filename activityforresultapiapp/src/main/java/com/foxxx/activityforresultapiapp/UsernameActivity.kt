package com.foxxx.activityforresultapiapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.foxxx.activityforresultapiapp.databinding.ActivityUserNameBinding

class UsernameActivity : AppCompatActivity() {
    private var _binding : ActivityUserNameBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityUsernameBinding = null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUserNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveUsernameButton.setOnClickListener {
            val username = binding.usernameEdittext.text.trim().toString()
            saveUsername(username)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun saveUsername(username: String) {
        Intent().apply {
            putExtra(EXTRA_USERNAME, username)
            setResult(RESULT_OK, this)
        }
    }

    companion object {

        const val EXTRA_USERNAME = "username"

        fun newIntent(context: Context) = Intent(context, UsernameActivity::class.java)
    }
}