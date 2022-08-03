package br.com.zup.marvel.ui.register.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.zup.marvel.*
import br.com.zup.marvel.domain.model.User
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterViewModelTest {

    @Test
    fun validateUserData_emptyName_returnErrorMessage() {
        val viewModel = RegisterViewModel()
        viewModel.validateUserData(user = User(name = ""))
        assert(viewModel.errorState.value == NAME_ERROR_MESSAGE)
    }

    @Test
    fun validateUserData_emptyEmail_returnErrorMessage() {
        val viewModel = RegisterViewModel()
        viewModel.validateUserData(user = User(name = "Livia", email = ""))
        assert(viewModel.errorState.value == EMAIL_ERROR_MESSAGE)
    }

    @Test
    fun validateUserData_emptyPassword_returnErrorMessage() {
        val viewModel = RegisterViewModel()
        viewModel.validateUserData(
            user = User(
                name = "Livia",
                email = "li@gmail.com",
                password = ""
            )
        )
        assert(viewModel.errorState.value == PASSWORD_ERROR_MESSAGE)
    }

    @Test
    fun validateUserData_nameLessThenThreeCharacters_returnErrorMessage() {
        val viewModel = RegisterViewModel()
        viewModel.validateUserData(user = User(name = "Li", email = "li@gmail.com", password = "1"))
        assert(viewModel.errorState.value == ERROR_VALIDATE_NAME)
    }

    @Test
    fun validateUserData_passwordLessThanEightCharacters_returnErrorMessage() {
        val viewModel = RegisterViewModel()
        viewModel.validateUserData(
            user = User(
                name = "Livia",
                email = "li@gmail.com",
                password = "1234567"
            )
        )
        assert(viewModel.errorState.value == ERROR_VALIDATE_PASSWORD)
    }

    @Test
    fun validateUserData_allFieldsCorrect_returnRegisterUser() {
        val viewModel = RegisterViewModel()
        val user = User(
            name = "Livia",
            email = "li@gmail.com",
            password = "12345678"
        )
        assert(viewModel.validateUserData(user))
    }

}