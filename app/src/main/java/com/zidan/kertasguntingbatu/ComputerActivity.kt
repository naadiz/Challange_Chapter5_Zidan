package com.zidan.kertasguntingbatu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.zidan.kertasguntingbatu.databinding.ActivityComputerBinding
import com.zidan.kertasguntingbatu.dialog.DialogFragment

class ComputerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComputerBinding

    private lateinit var enemyChoice: String
    private lateinit var meChoice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComputerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        binding.apply {
            Glide.with(this@ComputerActivity)
                .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
                .into(ivText)
        }

        binding.apply {
            pemainSatuTextView.text = name
        }

        setUpAction()
    }

    private fun setUpAction() {
        binding.apply {
            tvBatu.setOnClickListener() {
                setSelection(ROCK)
                computerChoose()
                matchGame()
            }

            tvKertasBtn.setOnClickListener() {
                setSelection(PAPER)
                computerChoose()
                matchGame()
            }

            tvGunting.setOnClickListener() {
                setSelection(SCISSORS)
                computerChoose()
                matchGame()
            }

            refBtn.setOnClickListener() {
                refreshGame()
            }
        }
    }

    private fun setSelection(typeSelection: String?) {
        binding.apply {
            when (typeSelection) {
                SCISSORS -> {
                    tvGunting.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvBatu.setBackgroundResource(0)
                    tvKertasBtn.setBackgroundResource(0)
                }
                ROCK -> {
                    tvBatu.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvKertasBtn.setBackgroundResource(0)
                    tvGunting.setBackgroundResource(0)
                }
                else -> {
                    tvKertasBtn.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvBatu.setBackgroundResource(0)
                    tvGunting.setBackgroundResource(0)
                }
            }
        }
        meChoice = typeSelection.toString()
    }

    private fun computerChoose() {
        val list = listOf<String>(PAPER, SCISSORS, ROCK)
        val randomElement = list.random()

        binding.apply {
            when (randomElement) {
                SCISSORS -> {
                    tvGuntingCom.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvBatuCom.setBackgroundResource(0)
                    tvKertasComBtn.setBackgroundResource(0)
                }
                ROCK -> {
                    tvBatuCom.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvKertasComBtn.setBackgroundResource(0)
                    tvGuntingCom.setBackgroundResource(0)
                }
                else -> {
                    tvKertasComBtn.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvBatuCom.setBackgroundResource(0)
                    tvGuntingCom.setBackgroundResource(0)
                }
            }
        }
        enemyChoice = randomElement.toString()
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    fun matchGame() {
        val name = intent.getStringExtra("name")

        binding.apply {
            if (meChoice == SCISSORS && enemyChoice == PAPER) {
                hasil("${name} \n MENANG!")
            } else if (meChoice == PAPER && enemyChoice == ROCK) {
                hasil("${name} \n MENANG!")
            } else if (meChoice == ROCK && enemyChoice == SCISSORS) {
                hasil("${name} \n MENANG!")
            } else if (meChoice == SCISSORS && enemyChoice == ROCK) {
                hasil("Pemain 2 \n MENANG!")
            } else if (meChoice == PAPER && enemyChoice == SCISSORS) {
                hasil("Pemain 2 \n MENANG!")
            } else if (meChoice == ROCK && enemyChoice == PAPER) {
                hasil("Pemain 2 \n MENANG!")
            } else if (meChoice == enemyChoice) {
                hasil("SERI!")
            }
        }
    }

    fun refreshGame() {
        binding.apply {
            tvBatuCom.setBackgroundResource(0)
            tvKertasComBtn.setBackgroundResource(0)
            tvGuntingCom.setBackgroundResource(0)

            tvKertasBtn.setBackgroundResource(0)
            tvBatu.setBackgroundResource(0)
            tvGunting.setBackgroundResource(0)
        }
    }

    fun hasil(hasil: String) {
        val dialogResult = DialogFragment()
        val bundle = Bundle()
        bundle.putString("hasil", hasil)
        dialogResult.arguments = bundle
        dialogResult.show(supportFragmentManager, "DialogResult")
    }

    companion object {
        const val SCISSORS = "SCISSORS"
        const val ROCK = "ROCK"
        const val PAPER = "PAPER"
    }
}