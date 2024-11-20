package com.seung.survey_kotlin.commons.converter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.seung.survey_kotlin.commons.dto.request.survey.SurveyRequest
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class ElementConverter :
    AttributeConverter<List<SurveyRequest?>?, String> {

    private val mapper: ObjectMapper = ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
    override fun convertToDatabaseColumn(attribute: List<SurveyRequest?>?): String {
        return try {
            mapper.writeValueAsString(attribute)
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException()
        }
    }

    override fun convertToEntityAttribute(dbData: String?): List<SurveyRequest?>? {
        val typeReference: TypeReference<List<SurveyRequest?>?> = object : TypeReference<List<SurveyRequest?>?>() {}
        return try {
            mapper.readValue(dbData, typeReference)
        } catch (e: JsonProcessingException) {
            throw RuntimeException(e)
        }
    }
}