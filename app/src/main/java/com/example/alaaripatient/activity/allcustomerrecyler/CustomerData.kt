package com.example.alaaripatient.activity.allcustomerrecyler

data class CustomerData(
    val _id: String,
    val area: String,
    val city: String,
    val country: String,
    val createdBy: String,
    val createdOn: Long,
    val default: String,
    val isActive: Boolean,
    val isDeleted: Boolean,
    val modifiedBy: String,
    val modifiedOn: Long,
    val ownerId: String,
    val street: String,
    val title: String
)