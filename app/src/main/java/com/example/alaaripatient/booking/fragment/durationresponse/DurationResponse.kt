package com.example.alaaripatient.booking.fragment.durationresponse

data class DurationResponse(
    val `data`: List<DurationModal>,
    val isSuccess: Boolean,
    val message: String
)