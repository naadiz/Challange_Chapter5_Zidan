package com.zidan.kertasguntingbatu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.zidan.kertasguntingbatu.adapter.LandingAdapter
import com.zidan.kertasguntingbatu.adapter.LandingAdapter.Companion.FIRST
import com.zidan.kertasguntingbatu.adapter.LandingAdapter.Companion.LAST
import com.zidan.kertasguntingbatu.adapter.LandingAdapter.Companion.SECOND
import com.zidan.kertasguntingbatu.content.ThirdFragment
import com.zidan.kertasguntingbatu.databinding.ActivityLandingBinding


class LandingActivity : AppCompatActivity() {
    lateinit var binding: ActivityLandingBinding
    lateinit var fragmentLast: Fragment
    lateinit var tabAdapter: LandingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
        setUpAction()
    }

    fun setViewPager() {
        binding.apply {
            vpSlider.apply {
                tabAdapter = LandingAdapter(this@LandingActivity)
                adapter = tabAdapter
                currentItem = 0
            }
            vpSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when (position) {
                        LandingAdapter.FIRST -> {
                            binding.ivNext.visibility = View.GONE
                        }
                        LandingAdapter.SECOND -> {
                            binding.ivNext.visibility = View.GONE
                        }
                        LandingAdapter.LAST -> {}
                    }
                }
            })

            TabLayoutMediator(tabIndicator, vpSlider) { tab, position ->
            }.attach()
        }
    }

    fun setUpAction() {
        binding.apply {
            ivNext.setOnClickListener { viewClick ->
                val fragment = tabAdapter.getRegisteredFragment(binding.vpSlider.currentItem)
                Log.d(
                    binding.vpSlider.currentItem.toString(),
                    "setUpAction: ${tabAdapter.getRegisteredFragment(binding.vpSlider.currentItem)}"
                )
                if (fragment is ThirdFragment) {
                    val intent = Intent(this@LandingActivity, MenuActivity::class.java)
                    intent.putExtra(
                        "name",
                        fragment.getNameData()
                    )
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LandingActivity
                        , "Anda bukan di halaman untuk menuliskan nama"
                        , Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun hideAndShowButton(isShow: Boolean) {
        binding.apply {
            if (isShow) {
                ivNext.visibility = View.VISIBLE
            } else {
                ivNext.visibility = View.GONE
            }
        }
    }
}
