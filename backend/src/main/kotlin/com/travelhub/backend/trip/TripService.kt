package com.travelhub.backend.trip

import org.springframework.stereotype.Service

@Service
class TripService {

    private val trips = mutableListOf(
        Trip(1, "Tokyo", "Japan"),
        Trip(2, "Munich", "Germany"),
        Trip(3, "Ho Chi Minh City", "Vietnam")
    )

    fun getTrips(): List<Trip> {
        return trips
    }

    fun getTrip(id: Long): Trip? {
        return trips.find { it.id == id }
    }
}