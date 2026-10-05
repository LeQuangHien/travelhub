package com.travelhub.backend.trip

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/trips")
class TripController(
    private val tripService: TripService
) {

    @GetMapping
    fun getTrips(): List<Trip> {
        return tripService.getTrips()
    }

    @GetMapping("/{id}")
    fun getTrip(
        @PathVariable id: Long
    ): Trip? {
        return tripService.getTrip(id)
    }
}