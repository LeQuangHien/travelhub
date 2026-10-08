package com.travelhub.backend.booking

import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository : JpaRepository<Booking, Long> {

    fun findByTripId(tripId: Long): List<Booking>
}