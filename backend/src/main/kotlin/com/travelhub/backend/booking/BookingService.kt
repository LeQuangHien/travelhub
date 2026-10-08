package com.travelhub.backend.booking

import com.travelhub.backend.trip.TripNotFoundException
import com.travelhub.backend.trip.TripRepository
import org.springframework.stereotype.Service

@Service
class BookingService(
    private val bookingRepository: BookingRepository,
    private val tripRepository: TripRepository
) {

    fun createBooking(
        tripId: Long,
        request: CreateBookingRequest
    ): Booking {
        val trip = tripRepository.findById(tripId)
            .orElseThrow { TripNotFoundException(tripId) }

        val booking = Booking(
            name = request.name,
            trip = trip
        )

        return bookingRepository.save(booking)
    }

    fun getBookingsForTrip(
        tripId: Long
    ): List<Booking> {
        if (!tripRepository.existsById(tripId)) {
            throw TripNotFoundException(tripId)
        }

        return bookingRepository.findByTripId(tripId)
    }
}