package br.com.zup.marvel.ui.register.viewmodel

import br.com.zup.marvel.NAME_ERROR_MESSAGE
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository
import org.junit.Test
import org.mockito.Mock

class RegisterViewModelTest{

    @Mock
    private val authenticationRepository = AuthenticationRepository()

    @Test
    fun validateUserData_emptyName_returnErrorMessage() {
        val userMock = User(
            name = "",
            email = "1@2.com",
            password = "11111111"
        )

        val errorMock = NAME_ERROR_MESSAGE

        val result = RegisterViewModel().validateUserData(userMock)

        assert(result.equals(errorMock))

    }

    @Test
    fun validateUserData_emptyEmail_returnErrorMessage() {
        val userMock = User(
            name = "",
            email = "1@2.com",
            password = "11111111"
        )

        val errorMock = NAME_ERROR_MESSAGE

        val result = RegisterViewModel().validateUserData(userMock)

        assert(result.equals(errorMock))

    }

}