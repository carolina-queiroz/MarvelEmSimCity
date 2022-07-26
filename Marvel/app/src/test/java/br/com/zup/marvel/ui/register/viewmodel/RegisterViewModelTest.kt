package br.com.zup.marvel.ui.register.viewmodel

import br.com.zup.marvel.NAME_ERROR_MESSAGE
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RegisterViewModelTest{

    @Mock
    private lateinit var authenticationRepository : AuthenticationRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        authenticationRepository = AuthenticationRepository()
    }

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