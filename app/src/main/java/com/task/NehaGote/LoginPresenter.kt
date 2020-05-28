package com.task.NehaGote

import com.task.NehaGote.LoginInteractor.OnLoginFinishedListener

class LoginPresenter internal constructor(private var loginView: LoginView?, private val loginInteractor: LoginInteractor) : OnLoginFinishedListener {
    fun validateCredentials(username: String?, password: String?): Boolean {
        return loginInteractor.login(username!!, password!!, this)
    }

    override fun onUsernameError() {
        if (loginView != null) {
            loginView!!.setUsernameError()
        }
    }

    override fun onPasswordError() {
        if (loginView != null) {
            loginView!!.setPasswordError()
        }
    }

    override fun onSuccess() {
        loginView?.redirectToMainActivity()
    }

}