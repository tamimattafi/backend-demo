package com.tamimattafi.backend.demo.api.requests

import com.fasterxml.jackson.annotation.JsonProperty

data class RegistrationRequest(
        @JsonProperty("username") val username: String,
        @JsonProperty("password") val password: String
)