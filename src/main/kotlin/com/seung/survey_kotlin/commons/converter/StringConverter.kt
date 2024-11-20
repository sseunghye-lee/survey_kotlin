package com.seung.survey_kotlin.commons.converter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

import jakarta.persistence.AttributeConverter
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class StringConverter :
    AttributeConverter<List<String?>?, String> {
    override fun convertToDatabaseColumn(attribute: List<String?>?): String {
        return try {
            mapper.writeValueAsString(attribute)
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException()
        }
    }

    override fun convertToEntityAttribute(dbData: String): List<String?>? {
        return try {
            mapper.readValue(dbData, object : TypeReference<List<String?>?>() {})
        } catch (e: IOException) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private val mapper: ObjectMapper = ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
    }

}