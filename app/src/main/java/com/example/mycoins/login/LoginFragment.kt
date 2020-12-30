package com.example.mycoins.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycoins.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val viewModel : LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentLoginBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.loginViewModel = viewModel


        viewModel.navigateToOverview.observe(this, Observer {
            if(it){
                this.findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToOverviewFragment()
                )
                this.viewModel.doneNavigating()
            }
        })


        return binding.root
    }
}