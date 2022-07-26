package br.com.zup.marvel.ui.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.marvel.LOGIN
import br.com.zup.marvel.REGISTER
import br.com.zup.marvel.USER_KEY
import br.com.zup.marvel.databinding.ActivityLoginBinding
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.ui.home.view.HomeActivity
import br.com.zup.marvel.ui.login.viewmodel.LoginViewModel
import br.com.zup.marvel.ui.register.view.RegisterActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser




class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = LOGIN

        binding.tvCreateAccount.setOnClickListener {
            goRegisterUser()
        }

        binding.btnLogin.setOnClickListener {
            val user = getUserData()
            viewModel.validateDataUser(user)
        }

        initObservers()

    }

    override fun onStart() {
        super.onStart()
        val actualUser = viewModel.getUser()
        actualUser?.reload()
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
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun goHome(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra(USER_KEY, user)
        }
        startActivity(intent)
    }
}