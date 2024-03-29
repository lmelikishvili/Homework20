package com.example.homework20.presentation.screen.register

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.homework20.R
import com.example.homework20.databinding.FragmentRegisterBinding
import com.example.homework20.presentation.base.BaseFragment
import com.example.homework20.presentation.event.users.UsersEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val viewModel: RegisterViewModel by viewModels()
    override fun setup() {
        binding.btnAdd.setOnClickListener{
            viewModel.onEvent(UsersEvent.CreateUser)
        }
    }

    override fun setupListeners() {

    }

    override fun bindData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.users.collect{
                    Log.d("usersListFromDB", "${it}")
                }
            }
        }
    }

    private fun handleNavigationEvents(event: RegisterViewModel.LogInUiEvent) {
        when (event) {
            is RegisterViewModel.LogInUiEvent.NavigateToLogin -> findNavController().navigate(
                R.id.action_registerFragment_to_welcomeFragment
            )
        }
    }
}