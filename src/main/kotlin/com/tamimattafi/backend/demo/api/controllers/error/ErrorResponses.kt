package com.tamimattafi.backend.demo.api.controllers.error

import com.tamimattafi.backend.demo.api.responses.global.ErrorResponse

object ErrorResponses {

    const val ERROR_NOT_FOUND = "Page Not Found"

    val ERROR_PAGE_NOT_FOUND
        get() = ErrorResponse(ERROR_NOT_FOUND, "This page cannot be found. Please check our repository at https://github.com/tamimattafi/backend-demo for more information")
}