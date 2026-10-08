package com.travelhub.backend.booking

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trips/{tripId}/bookings")
class BookingController(
    private val bookingService: BookingService
) {

    @PostMapping
    fun createBooking(
        @PathVariable tripId: Long,
        @Valid @RequestBody request: CreateBookingRequest
    ): ResponseEntity<Booking> {
        val booking = bookingService.createBooking(
            tripId = tripId,
            request = request
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(booking)
    }

    @GetMapping
    fun getBookings(
        @PathVariable tripId: Long
    ): List<Booking> {
        return bookingService.getBookingsForTrip(tripId)
    }
}