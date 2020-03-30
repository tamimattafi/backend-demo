package com.tamimattafi.backend.demo.api.controllers.auth

object Validator {

    const val USERNAME_MIN_SIZE = 4
    const val PASSWORD_MIN_SIZE = 8

    fun String.isValidUsername(): Boolean {
        return !contains(" ") && length >= USERNAME_MIN_SIZE
    }

    fun String.isValidEmail(): Boolean {
        return contains("@")
    }

    fun String.isValidPassword(): Boolean {
        return length >= PASSWORD_MIN_SIZE
    }
}