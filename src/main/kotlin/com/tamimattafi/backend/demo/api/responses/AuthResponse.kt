package com.tamimattafi.backend.demo.api.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthResponse(
        @JsonProperty("token") val token: String
)