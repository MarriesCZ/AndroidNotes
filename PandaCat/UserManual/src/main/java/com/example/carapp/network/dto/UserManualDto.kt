package com.example.carapp.network.dto

/**
 * DTO for user manual information
 */
data class UserManualDto(
    val modelCode: String,
    val vin: String,
    val carSoftwareVersion: String,
    val spaceSoftwareVersion: Int,
    val contentVersion: String,
    val documentType: String
)