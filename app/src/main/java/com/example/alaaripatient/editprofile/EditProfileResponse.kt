package com.example.alaaripatient.editprofile

data class EditProfileResponse(
    val `data`: EditProfileModal,
    val isSuccess: Boolean,
    val message: String
)