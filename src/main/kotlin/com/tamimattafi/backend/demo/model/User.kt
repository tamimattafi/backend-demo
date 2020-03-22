package com.tamimattafi.backend.demo.model

data class User(
        val id: Long,
        val username: String,
        val password: String
) {
    constructor(username: String, password: String) : this(Long.MIN_VALUE, username, password)
}