package com.tamimattafi.backend.demo.model

data class User(
        val id: Long?,
        val username: String,
        val email: String,
        val password: String
) {
    constructor(username: String, email: String, password: String) : this(null, username, email, password)
}