package com.tlh.noteapp.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.tlh.noteapp.R
import com.tlh.noteapp.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        binding.imageButton4.setOnClickListener { clickable(it) }
    }

    private fun clickable(view: View) {
        val popupMenu = PopupMenu(requireContext(), binding.imageButton4)
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.logout -> logOut()
                R.id.exit -> exitApp()
                else -> false
            }
        }
        popupMenu.show() // Ensure the popup menu is shown
    }

    private fun logOut(): Boolean {
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
        val action = ListFragmentDirections.actionListFragmentToLoginFragment()
        findNavController().navigate(action)
        return true
    }

    private fun exitApp(): Boolean {
        requireActivity().finish()
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
