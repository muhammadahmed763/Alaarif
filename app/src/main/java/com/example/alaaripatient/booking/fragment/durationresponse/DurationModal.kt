package com.example.alaaripatient.booking.fragment.durationresponse

data class DurationModal(
    val _id: String,
    val commission: Int,
    val consultantPrice: Int,
    val createdBy: String,
    val createdOn: Long,
    val customPrice: Double,
    val duration: String,
    val durationType: String,
    val isActive: Boolean,
    val isApproved: Boolean,
    val isDeleted: Boolean,
    val modifiedBy: String,
    val modifiedOn: Long,
    val ownerId: String,
    val serviceType: String,
    val undefined: Any
)