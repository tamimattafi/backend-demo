package com.tamimattafi.backend.demo.api.controllers.auth.register

import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_EMAIL_EXISTS
import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_EMPTY_EMAIL
import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_EMPTY_PASSWORD
import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_EMPTY_USERNAME
import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_INVALID_EMAIL
import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_INVALID_PASSWORD
import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_INVALID_USERNAME
import com.tamimattafi.backend.demo.api.controllers.auth.AuthResponses.ERROR_USERNAME_EXISTS
import com.tamimattafi.backend.demo.api.controllers.auth.AuthValidator.isValidEmail
import com.tamimattafi.backend.demo.api.controllers.auth.AuthValidator.isValidPassword
import com.tamimattafi.backend.demo.api.controllers.auth.AuthValidator.isValidUsername
import com.tamimattafi.backend.demo.api.requests.RegistrationRequest
import com.tamimattafi.backend.demo.api.responses.auth.AuthResponse
import com.tamimattafi.backend.demo.api.responses.global.ErrorResponse
import com.tamimattafi.backend.demo.model.User
import com.tamimattafi.backend.demo.services.UserService
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/register")
@RestController
class RegistrationController @Autowired constructor(private val userService: UserService) {

    @PostMapping
    fun login(@RequestBody registrationRequest: RegistrationRequest): Single<ResponseEntity<Any>>
        = userService.usernameExists(registrationRequest.username.toString())
            .zipWith<Boolean, Pair<Boolean, Boolean>>(
                    userService.emailExists(registrationRequest.email.toString()),
                    BiFunction { usernameExists, emailExists -> Pair(usernameExists, emailExists) }
            ).flatMap { exists -> registrationRequest.handle(exists) }

    private fun RegistrationRequest.handle(pair: Pair<Boolean, Boolean>): Single<ResponseEntity<Any>>
        = when {
            pair.first -> respond(ERROR_USERNAME_EXISTS, HttpStatus.CONFLICT)
            pair.second -> respond(ERROR_EMAIL_EXISTS, HttpStatus.CONFLICT)
            else -> validate()
        }

    private fun RegistrationRequest.validate(): Single<ResponseEntity<Any>> {

        if (username.isNullOrEmpty()) {
            return respondToValidation(ERROR_EMPTY_USERNAME)
        }

        if (!username.isValidUsername()) {
            return respondToValidation(ERROR_INVALID_USERNAME)
        }

        if (email.isNullOrEmpty()) {
            return respondToValidation(ERROR_EMPTY_EMAIL)
        }

        if (!email.isValidEmail()) {
            return respondToValidation(ERROR_INVALID_EMAIL)
        }

        if (password.isNullOrEmpty()) {
            return respondToValidation(ERROR_EMPTY_PASSWORD)
        }

        if (!password.isValidPassword()) {
            return respondToValidation(ERROR_INVALID_PASSWORD)
        }

        return User(username, email, password).register()
    }

    private fun User.register(): Single<ResponseEntity<Any>>
        = userService.insert(this).flatMap { user ->
        respond(AuthResponse("YOUR ID IS NOW: ${user.id} fucking ${user.username}!"), HttpStatus.CREATED)
        }

    private fun respond(body: Any, status: HttpStatus): Single<ResponseEntity<Any>>
        = Single.just(ResponseEntity<Any>(body, status))


    private fun respondToValidation(error: ErrorResponse): Single<ResponseEntity<Any>>
        = Single.just(ResponseEntity<Any>(error, HttpStatus.BAD_REQUEST))


}


