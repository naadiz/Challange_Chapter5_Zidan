package com.zidan.kertasguntingbatu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.zidan.kertasguntingbatu.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        binding.apply {
            tvChoicePlayer.text = "$name VS Pemain"
            tvChoiceCpu.text = "$name VS CPU"

            choicePlayer.setOnClickListener() {
                val mIntent = Intent(this@MenuActivity, PlayerActivity::class.java)
                mIntent.putExtra("name", name)
                startActivity(mIntent)
            }

            choiceCpu.setOnClickListener() {
                val mIntent = Intent(this@MenuActivity, ComputerActivity::class.java)
                mIntent.putExtra("name", name)
                startActivity(mIntent)
            }

            Snackbar.make(
                binding.menuActivity, "Selamat Datang $name", Snackbar.LENGTH_INDEFINITE
            )
                .setAction("Tutup") {
                }.show()
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

    companion object {
        const val NAME = ""
    }
}