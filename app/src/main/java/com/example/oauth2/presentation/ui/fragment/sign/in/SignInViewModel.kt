package com.example.oauth2.presentation.ui.fragment.sign.`in`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.presentation.state.UIState
import com.example.oauth2.base.BaseViewModel
import com.example.oauth2.domain.models.AuthToken
import com.example.oauth2.domain.models.AuthorizeModel
import com.example.oauth2.domain.usescases.AuthorizeUseCases
import com.example.oauth2.domain.usescases.CreateUserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val useCases: CreateUserUseCases,
    private val useCasesAuthorize: AuthorizeUseCases
) :
    BaseViewModel() {

    private val _everythingState = MutableLiveData<UIState<AuthToken>>()
    val everythingState: LiveData<UIState<AuthToken>> = _everythingState
    private val _authorizeState = MutableLiveData<UIState<AuthorizeModel>>()
    val authorizeState: LiveData<UIState<AuthorizeModel>> = _authorizeState
    fun createUser(username: String, pass: String) {
        subscribeTo(_everythingState) {
            useCases(username, pass)
        }
    }
    init {
        fetchAuthorize()
    }

    private fun fetchAuthorize() {
        subscribeTo(_authorizeState) {
            useCasesAuthorize()
        }
    }
}