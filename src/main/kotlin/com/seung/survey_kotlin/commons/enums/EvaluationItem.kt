package com.seung.survey_kotlin.commons.enums

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue


enum class EvaluationItem (
    private val id: String = "",
    private val desc: String = ""
) {
    CLEAN("CLEAN", "청결"),
    KIND("KIND", "친절"),
    PRICE("PRICE", "가격"),
    QUALITY("QUALITY", "품질"),
    USABILITY("USABILITY", "사용성");

    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())

        fun codes(): List<*> {
            val codes: MutableList<Map<String, String>> = ArrayList()
            for (obj in values()) {
                val map: MutableMap<String, String> = HashMap()
                map["name"] = obj.name
                map["id"] = obj.id
                map["desc"] = obj.desc
                codes.add(map)
            }
            return codes
        }
    }

    @JsonValue
    open fun getValue(): String? {
        return name
    }

    @JsonCreator
    open fun of(name: String?): EvaluationItem? {
        for (obj in values()) {
            if (obj.name.equals(name, ignoreCase = true)) {
                return obj
            }
        }
        return null
    }
}