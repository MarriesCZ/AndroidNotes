package com.example.carapp.network.modelcase

import android.content.Context
import com.example.carapp.network.RemoteRepository
import javax.inject.Inject


class UserManualRepositoryImpl @Inject constructor(
    private val appContext: Context,
    private val remoteRepository: RemoteRepository
) : UserManualRepository {
    override suspend fun getUserManualCurrent(version: String): String {
        val content = remoteRepository.getUserManual(vinCode = "0", softwareVersion = version) ?: return "error"
        return content.toString()
    }
}