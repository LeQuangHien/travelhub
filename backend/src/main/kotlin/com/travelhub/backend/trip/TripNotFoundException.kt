package com.travelhub.backend.trip

class TripNotFoundException(
    id: Long
) : RuntimeException("Trip $id was not found")