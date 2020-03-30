package com.tamimattafi.backend.demo.api.controllers.auth

import com.tamimattafi.backend.demo.api.responses.global.ErrorResponse

object AuthResponses {

    const val ERROR_REQUIRED_FIELD = "Required Field"
    const val ERROR_INVALID_FIELD = "Invalid Field"

    val ERROR_USERNAME_EXISTS
        get() = ErrorResponse(ERROR_INVALID_FIELD, "Username already exists. Please try a different one")

    val ERROR_EMAIL_EXISTS
        get() = ErrorResponse(ERROR_INVALID_FIELD, "Email already exists. Please try a different one")

    val ERROR_EMPTY_USERNAME
        get() = ErrorResponse(ERROR_REQUIRED_FIELD, "Username is required and must not be empty")

    val ERROR_INVALID_USERNAME
        get() = ErrorResponse(ERROR_INVALID_FIELD, "Username is invalid. It must not contain any spaces and must be at least 4 characters long")

    val ERROR_EMPTY_EMAIL
        get() = ErrorResponse(ERROR_REQUIRED_FIELD, "Email is required and must not be empty")

    val ERROR_INVALID_EMAIL
        get() = ErrorResponse(ERROR_INVALID_FIELD, "Email is invalid. Please make sure to use your real one")

    val ERROR_EMPTY_PASSWORD
        get() = ErrorResponse(ERROR_REQUIRED_FIELD, "Password is required and must not be empty")

    val ERROR_INVALID_PASSWORD
        get() = ErrorResponse(ERROR_INVALID_FIELD, "Password is invalid. It must be at least 8 characters long")
}