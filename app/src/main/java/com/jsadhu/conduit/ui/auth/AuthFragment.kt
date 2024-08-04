package com.jsadhu.conduit.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jsadhu.conduit.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private var _binding : FragmentAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentAuthBinding.inflate(inflater, container, false)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}