package com.travelhub.backend.booking

import jakarta.validation.constraints.NotBlank

data class CreateBookingRequest(
    @field:NotBlank
    val name: String
)