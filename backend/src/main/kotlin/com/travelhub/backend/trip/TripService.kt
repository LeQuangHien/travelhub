package com.travelhub.backend.trip

import org.springframework.stereotype.Service

@Service
class TripService(
    private val tripRepository: TripRepository
) {

    private val trips = mutableListOf(
        Trip(1, "Tokyo", "Japan"),
        Trip(2, "Munich", "Germany"),
        Trip(3, "Ho Chi Minh City", "Vietnam")
    )

    fun getTrips(): List<Trip> = trips

    fun getTrip(id: Long): Trip =
        trips.find { it.id == id }
            ?: throw TripNotFoundException(id)

    fun createTrip(
        request: CreateTripRequest
    ): Trip {

        val trip = Trip(
            destination = request.destination,
            country = request.country
        )

        return tripRepository.save(trip)
    }

    fun updateTrip(
        id: Long,
        request: UpdateTripRequest
    ): Trip {

        val trip = getTrip(id)

        trip.destination = request.destination
        trip.country = request.country

        return tripRepository.save(trip)
    }

    fun deleteTrip(id: Long) {

        val trip = getTrip(id)

        tripRepository.delete(trip)
    }
}