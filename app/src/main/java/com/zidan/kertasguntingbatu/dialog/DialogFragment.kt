package com.zidan.kertasguntingbatu.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.zidan.kertasguntingbatu.ComputerActivity
import com.zidan.kertasguntingbatu.databinding.FragmentDialogBinding

class DialogFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = FragmentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            if (arguments != null) {
                val hasil = arguments?.getString("hasil")
                tvHasil.text = hasil
            }

            btnReplay.setOnClickListener {
                dismiss()
                (activity as ComputerActivity?)?.refreshGame()
            }

            btnToMenu.setOnClickListener {
                activity?.finish()
            }
        }
    }
}