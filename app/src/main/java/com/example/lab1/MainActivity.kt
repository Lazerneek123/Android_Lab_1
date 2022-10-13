package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val textView = binding.text
        val inputText = binding.editText

        viewModel.text.observe(this) { text1 ->
            textView.text = text1.toString()
        }

        val button = binding.buttonChange
        button.setOnClickListener {
            viewModel.initText(inputText.text.toString())
            inputText.setText("")
        }
    }
}