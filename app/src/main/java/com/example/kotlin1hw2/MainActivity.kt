package com.example.kotlin1hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1hw2.databinding.ActivityMainBinding
import com.example.kotlin1hw2.extensions.customRandom
import com.example.kotlin1hw2.extensions.load
import com.example.kotlin1hw2.extensions.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var urlImage = arrayListOf(
        "https://clck.ru/amLGm",
        "https://clck.ru/amLK8",
        "https://clck.ru/amLKc",
        "https://clck.ru/amLKx",
        "https://clck.ru/amLLb"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnSubmit()
        btnRandomImage()
    }

    private fun btnRandomImage() {
        binding.btnRandom.setOnClickListener {
            binding.ivImage.load(urlImage.customRandom())
            showToast(getString(R.string.random_toast))
        }
    }

    private fun btnSubmit() {
        binding.btnSubmit.setOnClickListener {
            if (urlImage.add(binding.edtUrl.text.toString())) {
                showToast(getString(R.string.add_url))
            } else showToast(getString(R.string.error_download))
        }
    }
}