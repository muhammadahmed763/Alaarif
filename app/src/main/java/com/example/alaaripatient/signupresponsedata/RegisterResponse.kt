package com.example.alaaripatient.signupresponsedata

data class RegisterResponse(
    val `data`: Data,
    val isSuccess: Boolean,
    val message: String
)