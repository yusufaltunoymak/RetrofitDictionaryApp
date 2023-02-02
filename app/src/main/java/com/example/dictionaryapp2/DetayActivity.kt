package com.example.dictionaryapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionaryapp2.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kelime = intent.getSerializableExtra("nesne") as Kelimeler

        binding.textViewEng.text = kelime.ingilizce
        binding.textViewTr.text = kelime.turkce
    }
}