package com.zidan.kertasguntingbatu.content

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.zidan.kertasguntingbatu.LandingActivity
import com.zidan.kertasguntingbatu.MenuActivity
import com.zidan.kertasguntingbatu.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAction()

//        binding.apply {
//            ivNext.setOnClickListener {
//                if (binding.etName.text.isNotEmpty()) {
//
//                    val name = binding.etName.text.toString()
//
//                    val intent = Intent(activity, MenuActivity::class.java)
//                    intent.putExtra("name", name)
//                    startActivity(intent)
//                }
//            }
//        }
    }

    private fun setUpAction() {
        binding.apply {
            etName.doOnTextChanged { text, start, before, count ->
                (requireActivity() as LandingActivity).hideAndShowButton((text?.length ?: 0) > 0)
            }
        }
    }

    fun getNameData(): String?{
        return binding.etName.text.toString()
    }

    companion object {
        fun newInstance(page: Int) = ThirdFragment()
    }
}