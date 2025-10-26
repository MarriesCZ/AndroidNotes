package com.example.carapp.network.helper

import com.example.carapp.network.dto.UserManualDto
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class UserManualDtoDeserializer : JsonDeserializer<UserManualDto> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): UserManualDto {
        val jsonObject = json?.asJsonObject

        val userManualDto = if (jsonObject != null) {
            val modelCode = jsonObject.get("modelCode")?.asString ?: ""
            val vin = jsonObject.get("modelCode")?.asString ?: ""
            val carSoftwareVersion = jsonObject.get("carSoftwareVersion")?.asString ?: ""
            val spaceSoftwareVersion = jsonObject.get("spaceSoftwareVersion")?.asInt ?: 0
            val contentVersion = jsonObject.get("contentVersion")?.asString ?: ""
            val documentType = jsonObject.get("documentType")?.asString ?: ""

            UserManualDto(
                modelCode = modelCode,
                vin = vin,
                carSoftwareVersion = carSoftwareVersion,
                spaceSoftwareVersion = spaceSoftwareVersion,
                contentVersion = contentVersion,
                documentType = documentType,
            )
        } else {
            UserManualDto(
                modelCode = "",
                vin = "",
                carSoftwareVersion = "",
                spaceSoftwareVersion = 0,
                contentVersion = "",
                documentType = "",
            )
        }

        return userManualDto
    }
}