package com.tlh.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tlh.fragment.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) { // burada componentları bind yap
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            next(it)

        }
    }

    private fun next(view: View) {
        val go = findNavController().navigate(R.id.action_fragment1_to_fragment2)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}