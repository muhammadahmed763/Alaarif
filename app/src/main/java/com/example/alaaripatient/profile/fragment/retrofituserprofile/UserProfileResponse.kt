package com.example.alaaripatient.profile.fragment.retrofituserprofile

data class UserProfileResponse(
    val `data`: List<UserProfileModalClass>,
    val isSuccess: Boolean,
    val message: String
)