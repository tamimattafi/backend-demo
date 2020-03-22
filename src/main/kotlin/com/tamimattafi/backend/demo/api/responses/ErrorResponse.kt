package com.tamimattafi.backend.demo.api.responses

import com.fasterxml.jackson.annotation.JsonProperty

class ErrorResponse(
        @JsonProperty("message") val message: String
)