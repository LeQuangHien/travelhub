package com.travelhub.backend.trip

import jakarta.validation.constraints.NotBlank

data class CreateTripRequest(
    @field:NotBlank
    val destination: String,

    @field:NotBlank
    val country: String
)