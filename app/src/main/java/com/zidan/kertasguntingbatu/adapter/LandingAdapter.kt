package com.zidan.kertasguntingbatu.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zidan.kertasguntingbatu.content.FirstFragment
import com.zidan.kertasguntingbatu.content.SecondFragment
import com.zidan.kertasguntingbatu.content.ThirdFragment

class LandingAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity){
    private val fragments = listOf(
        FirstFragment.newInstance(FIRST),
        SecondFragment.newInstance(SECOND),
        ThirdFragment.newInstance(LAST)
    )

    companion object{
        const val FIRST = 0
        const val SECOND = 1
        const val LAST = 2
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getRegisteredFragment(position: Int): Fragment = fragments[position]
}