package com.zidan.kertasguntingbatu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.zidan.kertasguntingbatu.databinding.ActivityPlayerBinding
import com.zidan.kertasguntingbatu.dialog.SecondDialogFragment

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding

    private lateinit var enemyChoice: String
    private lateinit var meChoice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        binding.apply {
            Glide.with(this@PlayerActivity)
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
            tvBatuDua.isEnabled = false
            tvBatuDua.isClickable = false

            tvKertasDua.isEnabled = false
            tvKertasDua.isClickable = false

            tvGuntingDua.isEnabled = false
            tvGuntingDua.isClickable = false

            tvBatu.setOnClickListener() {
                setSelection(ROCK)

                tvBatuDua.isEnabled = true
                tvBatuDua.isClickable = true

                tvKertasDua.isEnabled = true
                tvKertasDua.isClickable = true

                tvGuntingDua.isEnabled = true
                tvGuntingDua.isClickable = true

                tvBatuDua.setOnClickListener(){
                    setSelectionPlayerTwo(ROCK)
                    matchGame()
                }
                tvKertasDua.setOnClickListener(){
                    setSelectionPlayerTwo(PAPER)
                    matchGame()
                }
                tvGuntingDua.setOnClickListener(){
                    setSelectionPlayerTwo(SCISSORS)
                    matchGame()
                }
            }

            tvKertas.setOnClickListener() {
                setSelection(PAPER)

                tvBatuDua.isEnabled = true
                tvBatuDua.isClickable = true

                tvKertasDua.isEnabled = true
                tvKertasDua.isClickable = true

                tvGuntingDua.isEnabled = true
                tvGuntingDua.isClickable = true

                tvBatuDua.setOnClickListener(){
                    setSelectionPlayerTwo(ROCK)
                    matchGame()
                }
                tvKertasDua.setOnClickListener(){
                    setSelectionPlayerTwo(PAPER)
                    matchGame()
                }
                tvGuntingDua.setOnClickListener(){
                    setSelectionPlayerTwo(SCISSORS)
                    matchGame()
                }
            }

            tvGunting.setOnClickListener() {
                setSelection(SCISSORS)

                tvBatuDua.isEnabled = true
                tvBatuDua.isClickable = true

                tvKertasDua.isEnabled = true
                tvKertasDua.isClickable = true

                tvGuntingDua.isEnabled = true
                tvGuntingDua.isClickable = true

                tvBatuDua.setOnClickListener(){
                    setSelectionPlayerTwo(ROCK)
                    matchGame()
                }
                tvKertasDua.setOnClickListener(){
                    setSelectionPlayerTwo(PAPER)
                    matchGame()
                }
                tvGuntingDua.setOnClickListener(){
                    setSelectionPlayerTwo(SCISSORS)
                    matchGame()
                }
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
                    tvKertas.setBackgroundResource(0)
                }
                ROCK -> {
                    tvBatu.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvKertas.setBackgroundResource(0)
                    tvGunting.setBackgroundResource(0)
                }
                else -> {
                    tvKertas.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvBatu.setBackgroundResource(0)
                    tvGunting.setBackgroundResource(0)
                }
            }
        }
        meChoice = typeSelection.toString()
    }

    private fun setSelectionPlayerTwo(typeSelectionPlayerTwo: String?) {
        binding.apply {
            when (typeSelectionPlayerTwo) {
                SCISSORS -> {
                    tvGuntingDua.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvBatuDua.setBackgroundResource(0)
                    tvKertasDua.setBackgroundResource(0)
                }
                ROCK -> {
                    tvBatuDua.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvKertasDua.setBackgroundResource(0)
                    tvGuntingDua.setBackgroundResource(0)
                }
                else -> {
                    tvKertasDua.setBackgroundResource(R.drawable.bg_ellipse_selector)
                    tvBatuDua.setBackgroundResource(0)
                    tvGuntingDua.setBackgroundResource(0)
                }
            }
        }
        enemyChoice = typeSelectionPlayerTwo.toString()
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
            tvBatuDua.setBackgroundResource(0)
            tvKertasDua.setBackgroundResource(0)
            tvGuntingDua.setBackgroundResource(0)

            tvKertas.setBackgroundResource(0)
            tvBatu.setBackgroundResource(0)
            tvGunting.setBackgroundResource(0)

            tvBatuDua.isEnabled = false
            tvBatuDua.isClickable = false

            tvKertasDua.isEnabled = false
            tvKertasDua.isClickable = false

            tvGuntingDua.isEnabled = false
            tvGuntingDua.isClickable = false
        }
    }

    fun hasil(hasil: String) {
        val dialogResult = SecondDialogFragment()
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