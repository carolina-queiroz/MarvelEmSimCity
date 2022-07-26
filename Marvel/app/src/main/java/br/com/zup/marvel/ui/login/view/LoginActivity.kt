package br.com.zup.marvel.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.marvel.R
import br.com.zup.marvel.USER_KEY
import br.com.zup.marvel.databinding.ActivityLoginBinding
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.ui.home.view.HomeActivity
import br.com.zup.marvel.ui.login.viewmodel.LoginViewModel
import br.com.zup.marvel.ui.register.view.RegisterActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCreateAccount.setOnClickListener {
            goRegisterUser()
        }

        binding.btnLogin.setOnClickListener {
            val user = getUserData()
            viewModel.validateDataUser(user)
        }

        initObservers()

    }

    private fun goRegisterUser() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    private fun getUserData(): User {
        return User(
            email = binding.etEmailLogin.text.toString(),
            password = binding.etPasswordLogin.text.toString()
        )
    }

    private fun initObservers() {
        viewModel.loginState.observe(this) {
            goHome(it)
        }

        viewModel.errorState.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun goHome(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra(USER_KEY, user)
        }
        startActivity(intent)
    }
}