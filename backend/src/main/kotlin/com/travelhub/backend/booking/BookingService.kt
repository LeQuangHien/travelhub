package com.travelhub.backend.booking

import com.travelhub.backend.trip.TripNotFoundException
import com.travelhub.backend.trip.TripRepository
import org.springframework.stereotype.Service

@Service
class BookingService(
    private val bookingRepository: BookingRepository, private val tripRepository: TripRepository
) {

    fun createBooking(
        tripId: Long,
        request: CreateBookingRequest
    ): BookingResponse {

        val trip = tripRepository.findById(tripId)
            .orElseThrow { TripNotFoundException(tripId) }
        val booking = Booking(
            name = request.name,
            trip = trip
        )

        val savedBooking = bookingRepository.save(booking)
        return savedBooking.toResponse()
    }

    fun getBookingsForTrip(
        tripId: Long
    ): List<BookingResponse> {
        if (!tripRepository.existsById(tripId)) {
            throw TripNotFoundException(tripId)
        }

        return bookingRepository
            .findByTripId(tripId)
            .map { it.toResponse() }
    }
}