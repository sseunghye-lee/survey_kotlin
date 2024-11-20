package com.seung.survey_kotlin.commons.enums

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class UIType (
    private val id: String = "",
    private val desc: String = ""
) {
    RADIO("RADIO", "라디오버튼"),
    TEXT("TEXT", "직접 입력");

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
    open fun of(name: String?): UIType? {
        for (obj in values()) {
            if (obj.name.equals(name, ignoreCase = true)) {
                return obj
            }
        }
        return null
    }

}