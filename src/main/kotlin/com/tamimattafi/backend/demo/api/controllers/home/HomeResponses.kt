package com.tamimattafi.backend.demo.api.controllers.home

import com.tamimattafi.backend.demo.api.responses.global.ErrorResponse

object HomeResponses {

    const val ERROR_NOT_FOUND = "Page Not Found"

    const val RESPONSE_WELCOME = "<h1>Welcome to Kotlin Spring Boot demo app!</h1>" +
            "\n<p> This app was designed for educational purposes in order to learn and teach!" +
            "\n This app can be used by both back-end, or even by front-end developers to learn to implement REST Api clients!</p>" +
            "\n<h2> More information could be found on our github repo: <b>https://github.com/tamimattafi/backend-demo</b></h2>" +
            "\n<h1> Happy Coding!<h1>"

    val ERROR_PAGE_NOT_FOUND
        get() = ErrorResponse(ERROR_NOT_FOUND, "This page cannot be found. Please check our repository at https://github.com/tamimattafi/backend-demo for more information")
}