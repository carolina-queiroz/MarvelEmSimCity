package br.com.zup.marvel.ui.register.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.zup.marvel.*
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository
import br.com.zup.marvel.domain.repository.AuthenticationRepositoryFactory

class RegisterViewModel : ViewModel() {
    private val authenticationRepository : AuthenticationRepository by lazy {
        AuthenticationRepositoryFactory.create()
    }

    private var _registerState = MutableLiveData<User>()
    val registerState: LiveData<User> = _registerState

    private var _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> = _errorState

    fun validateUserData(user: User): Boolean {
        when {
            user.name.isEmpty() -> {
                _errorState.value = NAME_ERROR_MESSAGE
                return false
            }
            user.email.isEmpty() -> {
                _errorState.value = EMAIL_ERROR_MESSAGE
                return false
            }
            user.password.isEmpty() -> {
                _errorState.value = PASSWORD_ERROR_MESSAGE
                return false
            }
            user.name.length < 3 -> {
                _errorState.value = ERROR_VALIDATE_NAME
                return false
            }
            user.password.length < 8 -> {
                _errorState.value = ERROR_VALIDATE_PASSWORD
                return false
            }
            Patterns.EMAIL_ADDRESS.matcher(user.email).matches().not() ->{
                _errorState.value = INVALID_EMAIL
                return false
            }
            else -> {
                return true
            }

        }
    }

    fun registerUser(user: User) {
        if (validateUserData(user)) {
            try {
                authenticationRepository.registerUser(
                    user.email,
                    user.password
                ).addOnSuccessListener {

                    authenticationRepository.updateUserProfile(user.name)?.addOnSuccessListener {
                        _registerState.value = user
                    }

                }.addOnFailureListener {
                    _errorState.value = CREATE_USER_ERROR_MESSAGE
                }
            } catch (e: Exception) {
                _errorState.value = e.message
            }
        }
    }
}