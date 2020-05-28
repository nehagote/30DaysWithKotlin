package com.task.NehaGote

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    private var presenter: LoginPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        InitiateView()
    }

    private fun InitiateView() {
        btn_Login?.setOnClickListener { view: View? ->
            if (validateCredentials(et_Username?.getText().toString(), et_Password?.getText().toString())) {
                redirectToMainActivity()
            }
        }
    }

    override fun setUsernameError() {
        et_Username!!.error = getString(R.string.username_error)
    }

    override fun setPasswordError() {
        et_Password!!.error = getString(R.string.password_error)
    }

    override fun redirectToMainActivity() {
        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun validateCredentials(UserName: String?, Password: String?): Boolean {
        presenter = LoginPresenter(this, LoginInteractor())
        return presenter!!.validateCredentials(UserName, Password)
    }
}