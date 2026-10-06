package com.travelhub.backend.error

import com.travelhub.backend.trip.TripNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(TripNotFoundException::class)
    fun handleTripNotFound(
        exception: TripNotFoundException
    ): ResponseEntity<ApiError> {

        val error = ApiError(
            code = "TRIP_NOT_FOUND",
            message = exception.message ?: "Trip not found"
        )

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(error)
    }
}