package com.example.carapp.network

import com.example.carapp.network.dto.UserManualDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API end points
 */
interface UserManualApi {
    /**
     * Get manual data without authentication
     */
    @GET("/user/{id}")
    suspend fun getUserManual(@Path("id") id: String): UserManualDto
}