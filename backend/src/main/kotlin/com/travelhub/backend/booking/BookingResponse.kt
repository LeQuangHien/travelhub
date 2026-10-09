package com.travelhub.backend.booking

data class BookingResponse(
    val id: Long,
    val name: String,
    val tripId: Long
)

fun Booking.toResponse(): BookingResponse {
    return BookingResponse(
        id = id,
        name = name,
        tripId = trip.id
    )
}