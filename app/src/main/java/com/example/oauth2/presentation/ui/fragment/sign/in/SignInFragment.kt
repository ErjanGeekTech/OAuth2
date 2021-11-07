package com.example.oauth2.presentation.ui.fragment.sign.`in`

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.presentation.state.UIState
import com.example.oauth2.R
import com.example.oauth2.base.BaseFragment
import com.example.oauth2.data.local.sharedpreferences.PreferencesHelper
import com.example.oauth2.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>(
    R.layout.fragment_sign_in
) {

    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun setupListeners() {
        clickOk()
    }

    override fun setupObserves() {
        subscribeToEverything()
        subscribeToAuthorize()
    }

    private fun clickOk() {
        binding.btnReady.setOnClickListener {
            viewModel.createUser(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString()
            )
        }
    }

    private fun subscribeToEverything() {
        viewModel.everythingState.observe(viewLifecycleOwner, {
            when (it) {
                is UIState.Loading -> {
                    Log.e("anime", "loading")
                }
                is UIState.Error -> {
                    Log.e("anime", it.error)
                }
                is UIState.Success -> {
                    preferencesHelper.refreshToken = it.data.refreshToken
                    preferencesHelper.expiresIn = it.data.expiresIn
                    Log.e("anime", "${it.data}")
                }
            }
        })
    }

    private fun subscribeToAuthorize() {
        viewModel.authorizeState.observe(viewLifecycleOwner, {
            when (it) {
                is UIState.Loading -> {
                    Log.e("anime", "loading")
                }
                is UIState.Error -> {
                    Log.e("anime", "Error: ${it.error}")
                }
                is UIState.Success -> {
                    Log.e("anime", "${it.data}")
                }
            }
        })
    }
}