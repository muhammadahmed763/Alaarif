package com.example.alaaripatient.profile.fragment.profileresponse

data class ProfileResonse(
    val `data`: List<ProfileDataClass>,
    val isSuccess: Boolean,
    val message: String
)