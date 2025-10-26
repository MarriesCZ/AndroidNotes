package com.example.carapp.network.modelcase


/**
 * Release notes repository
 */
interface UserManualRepository {
    // Current release notes
    suspend fun getUserManualCurrent(version: String): String
}