package br.com.zup.marvel.ui.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import br.com.zup.marvel.*
import br.com.zup.marvel.databinding.ActivityRegisterBinding
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository
import br.com.zup.marvel.ui.home.view.HomeActivity
import br.com.zup.marvel.ui.register.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterAccount.setOnClickListener {
            val user = getUserData()
            viewModel.validateDataUser(user)
        }

        initObservers()
    }

    private fun initObservers() {
        viewModel.registerState.observe(this) {
            goHome(it)
        }

        viewModel.errorState.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun getUserData(): User {
        return User(
            name = binding.etNameRegister.text.toString(),
            email = binding.etEmailRegister.text.toString(),
            password = binding.etPasswordRegister.text.toString()
        )
    }

    private fun goHome(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra(USER_KEY, user)
        }
        startActivity(intent)
    }

}