package com.example.alaaripatient.home.fragement.retrofitmvvm

data class CounsellingModal(
    val _id: String,
    val createdBy: String,
    val createdOn: Long,
    val imageUrl: String,
    val isActive: Boolean,
    val isApproved: Boolean,
    val isDeleted: Boolean,
    val modifiedBy: String,
    val modifiedOn: Long,
    val ownerId: String,
    val topicName: String,
    val topicNameArabic: String,
    val undefined: Any
):java.io.Serializable