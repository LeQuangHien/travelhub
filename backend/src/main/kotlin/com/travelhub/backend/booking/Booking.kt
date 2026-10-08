package com.travelhub.backend.booking

import com.travelhub.backend.trip.Trip
import jakarta.persistence.*

@Entity
@Table(name = "bookings")
class Booking(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    var trip: Trip
)