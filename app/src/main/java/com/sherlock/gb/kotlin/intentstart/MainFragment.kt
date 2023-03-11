package com.sherlock.gb.kotlin.intentstart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sherlock.gb.kotlin.intentstart.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    lateinit var text: String

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get(){
            return _binding!!
        }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            requireActivity().startService(Intent(requireContext(),SendService::class.java).apply {
                putExtra("editText",binding.editText.text.toString())
            })
        }
        binding.editText.setOnClickListener{
            text = binding.editText.text.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}