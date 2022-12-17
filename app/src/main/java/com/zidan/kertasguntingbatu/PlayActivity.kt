package com.zidan.kertasguntingbatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.zidan.kertasguntingbatu.databinding.ActivityPlayBinding
import com.zidan.kertasguntingbatu.dialog.DialogFragment

class PlayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayBinding

    private lateinit var enemyChoice: String
    private lateinit var meChoice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
        binding.apply {
            if (meChoice == SCISSORS && enemyChoice == PAPER) {
                textViewOneVs.text = PLAYERONE
                textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                textViewOneVs.setBackgroundResource(R.color.win_color)
                textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.white))
            } else if (meChoice == PAPER && enemyChoice == ROCK) {
                textViewOneVs.text = PLAYERONE
                textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                textViewOneVs.setBackgroundResource(R.color.win_color)
                textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.white))
            } else if (meChoice == ROCK && enemyChoice == SCISSORS) {
                textViewOneVs.text = PLAYERONE
                textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                textViewOneVs.setBackgroundResource(R.color.win_color)
                textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.white))
            } else if (meChoice == SCISSORS && enemyChoice == ROCK) {
                textViewOneVs.text = PLAYERTWO
                textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                textViewOneVs.setBackgroundResource(R.color.win_color)
                textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.white))
            } else if (meChoice == PAPER && enemyChoice == SCISSORS) {
                textViewOneVs.text = PLAYERTWO
                textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                textViewOneVs.setBackgroundResource(R.color.win_color)
                textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.white))
            } else if (meChoice == ROCK && enemyChoice == PAPER) {
                textViewOneVs.text = PLAYERTWO
                textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                textViewOneVs.setBackgroundResource(R.color.win_color)
                textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.white))
            } else if (meChoice == enemyChoice) {
                textViewOneVs.text = DRAW
                textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                textViewOneVs.setBackgroundResource(R.color.draw_color)
                textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.white))
            }
        }
    }

    private fun refreshGame() {
        binding.apply {
            textViewOneVs.text = VERSUS
            textViewOneVs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 90F)
            textViewOneVs.setTextColor(ContextCompat.getColor(this@PlayActivity, R.color.red_txt))
            textViewOneVs.setBackgroundColor(0)

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
        const val DRAW = "DRAW!"
        const val PLAYERONE = "Pemain 1 MENANG!"
        const val PLAYERTWO = "Pemain 2 MENANG!"
        const val VERSUS = "VS"
    }
}