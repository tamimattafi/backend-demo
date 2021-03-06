package com.tamimattafi.backend.demo.api.controllers.home

import com.tamimattafi.backend.demo.api.controllers.home.HomeResponses.ERROR_PAGE_NOT_FOUND
import com.tamimattafi.backend.demo.api.controllers.home.HomeResponses.RESPONSE_WELCOME
import com.tamimattafi.backend.demo.api.responses.global.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping("/error")
    fun error(): ResponseEntity<ErrorResponse> = ResponseEntity(ERROR_PAGE_NOT_FOUND, HttpStatus.NOT_FOUND)

    @GetMapping("/")
    fun home(): ResponseEntity<String> = ResponseEntity(RESPONSE_WELCOME, HttpStatus.OK)

}