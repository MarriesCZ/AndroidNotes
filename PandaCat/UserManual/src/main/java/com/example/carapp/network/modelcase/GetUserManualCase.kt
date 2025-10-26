package com.example.carapp.network.modelcase

import javax.inject.Inject

/**
 * Get current release notes json file
 */
class GetUserManualCase @Inject constructor(
    private val userManualRepository: UserManualRepository
) {
    suspend operator fun invoke(version: String): String =
        userManualRepository.getUserManualCurrent(version = version)
}