package com.tamimattafi.backend.demo.api.controllers

import com.tamimattafi.backend.demo.api.requests.RegistrationRequest
import com.tamimattafi.backend.demo.model.User
import com.tamimattafi.backend.demo.services.UserService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import jdk.net.SocketFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/register")
@RestController
class RegistrationController @Autowired constructor(private val userService: UserService) {

    @PostMapping
    fun login(@RequestBody registrationRequest: RegistrationRequest): Single<ResponseEntity<String>>
        = userService.userExists(registrationRequest.username)
            .flatMap { exists -> handleUserExistance(exists, registrationRequest) }

    private fun handleUserExistance(exists: Boolean, registrationRequest: RegistrationRequest): Single<ResponseEntity<String>>
        = if (exists) Single.just(ResponseEntity("Username already exists. Please try an other one", HttpStatus.CONFLICT))
            else userService.insert(User(registrationRequest.username, registrationRequest.password)).map { user ->
                ResponseEntity("User was successfully created with the id: ${user.id}", HttpStatus.CREATED)
            }

}