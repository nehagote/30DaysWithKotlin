package com.task.NehaGote

class LoginInteractor {
    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener): Boolean {
        if (username == "") {
            listener.onUsernameError()
            return false
        }
        if (password == "") {
            listener.onPasswordError()
            return false
        }
        listener.onSuccess()
        return true
    }
}