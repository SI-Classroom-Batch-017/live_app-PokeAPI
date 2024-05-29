package com.example.liveappuserapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.liveappuserapi.MainViewModel
import com.example.liveappuserapi.R
import com.example.liveappuserapi.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Fake User posten
        viewModel.postUser()

        binding.refreshFAB.setOnClickListener {
            viewModel.loadUsers()
        }

        viewModel.users.observe(viewLifecycleOwner){
            val adapter = UserAdapter(it)
            binding.userRV.adapter = adapter
        }
    }

}