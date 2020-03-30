package com.tamimattafi.backend.demo.api.controllers.home

import com.tamimattafi.backend.demo.api.responses.global.ErrorResponse

object HomeResponses {

    const val ERROR_NOT_FOUND = "Page Not Found"

    const val RESPONSE_WELCOME = "Welcome to Kotlin Spring Boot demo app!" +
            "\n This app was designed for educational purposes in order to learn and teach!" +
            "\n This app can be used by both back-end, or even by front-end developers to learn to implement REST Api clients" +
            "\n More information could be found on our github repo: https://github.com/tamimattafi/backend-demo" +
            "\n Happy Coding!"

    val ERROR_PAGE_NOT_FOUND
        get() = ErrorResponse(ERROR_NOT_FOUND, "This page cannot be found. Please check our repository at https://github.com/tamimattafi/backend-demo for more information")
}