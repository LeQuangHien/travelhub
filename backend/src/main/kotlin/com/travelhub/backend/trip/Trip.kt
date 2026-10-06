package com.travelhub.backend.trip

import jakarta.persistence.*

@Entity
@Table(name = "trips")
class Trip(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var destination: String,

    var country: String
)