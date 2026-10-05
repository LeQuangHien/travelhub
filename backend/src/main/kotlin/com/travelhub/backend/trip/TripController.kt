package com.travelhub.backend.trip

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trips")
class TripController(
    private val tripService: TripService
) {

    @GetMapping
    fun getTrips(): List<Trip> =
        tripService.getTrips()

    @GetMapping("/{id}")
    fun getTrip(
        @PathVariable id: Long
    ): ResponseEntity<Trip> {
        val trip = tripService.getTrip(id)
            ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(trip)
    }

    @PostMapping
    fun createTrip(
        @Valid @RequestBody request: CreateTripRequest
    ): ResponseEntity<Trip> {
        val trip = tripService.createTrip(request)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(trip)
    }

    @PutMapping("/{id}")
    fun updateTrip(
        @PathVariable id: Long,
        @Valid @RequestBody request: UpdateTripRequest
    ): ResponseEntity<Trip> {
        val trip = tripService.updateTrip(id, request)
            ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(trip)
    }

    @DeleteMapping("/{id}")
    fun deleteTrip(
        @PathVariable id: Long
    ): ResponseEntity<Void> {
        val deleted = tripService.deleteTrip(id)

        return if (deleted) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}