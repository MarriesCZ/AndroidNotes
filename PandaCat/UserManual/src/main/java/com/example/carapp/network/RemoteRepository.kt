package com.example.carapp.network

import android.util.Log
import com.example.carapp.network.dto.UserManualDto
import javax.inject.Inject


/**
 * Class to call remote API methods
 * Checks for connectivity errors and exceptions
 */
class RemoteRepository @Inject constructor(
    private val userManualApi: UserManualApi
) {
    suspend fun getUserManual(vinCode: String, softwareVersion: String): UserManualDto? {
        return try {
            userManualApi.getUserManual(vinCode)
        } catch (exception: Exception) {
            Log.d("RemoteRepository", "Connection exception in getUserManual")
            Log.d("RemoteRepository", exception.toString())
            null
        }
    }
}