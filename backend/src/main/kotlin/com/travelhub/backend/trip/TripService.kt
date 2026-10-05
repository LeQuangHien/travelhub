package com.travelhub.backend.trip

import org.springframework.stereotype.Service

@Service
class TripService {

    private val trips = mutableListOf(
        Trip(1, "Tokyo", "Japan"),
        Trip(2, "Munich", "Germany"),
        Trip(3, "Ho Chi Minh City", "Vietnam")
    )

    fun getTrips(): List<Trip> = trips

    fun getTrip(id: Long): Trip? =
        trips.find { it.id == id }

    fun createTrip(request: CreateTripRequest): Trip {
        val nextId = (trips.maxOfOrNull { it.id } ?: 0) + 1

        val trip = Trip(
            id = nextId,
            destination = request.destination,
            country = request.country
        )

        trips.add(trip)

        return trip
    }

    fun updateTrip(id: Long, request: UpdateTripRequest): Trip? {
        val index = trips.indexOfFirst { it.id == id }

        if (index == -1) {
            return null
        }

        val updatedTrip = Trip(
            id = id,
            destination = request.destination,
            country = request.country
        )

        trips[index] = updatedTrip

        return updatedTrip
    }

    fun deleteTrip(id: Long): Boolean {
        return trips.removeIf { it.id == id }
    }
}