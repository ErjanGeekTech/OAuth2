package com.example.oauth2.presentation.ui.fragment.sign.up

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.oauth2.R
import com.example.oauth2.base.BaseFragment
import com.example.oauth2.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>(
    R.layout.fragment_sign_up
) {

    override val binding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by viewModels()
}