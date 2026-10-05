package com.travelhub.backend.trip

import jakarta.validation.constraints.NotBlank

data class UpdateTripRequest(
    @field:NotBlank
    val destination: String,

    @field:NotBlank
    val country: String
)