package com.tamimattafi.backend.demo.api.controllers.error

import com.tamimattafi.backend.demo.api.controllers.error.ErrorResponses.ERROR_PAGE_NOT_FOUND
import com.tamimattafi.backend.demo.api.responses.global.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/error")
class ErrorController {

    @GetMapping
    fun error(): ResponseEntity<ErrorResponse> = ResponseEntity(ERROR_PAGE_NOT_FOUND, HttpStatus.NOT_FOUND)

}