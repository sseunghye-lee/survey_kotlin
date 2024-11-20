package com.seung.survey_kotlin.business.survey.domain

import com.seung.survey_kotlin.commons.converter.ElementConverter
import com.seung.survey_kotlin.commons.converter.StringConverter
import com.seung.survey_kotlin.commons.dto.request.survey.SurveyRequest
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table
class Survey(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "bigint COMMENT '설문지 아이디'")
        val surveyId: Long? = null,
        @Column(columnDefinition = "mediumText COMMENT '추가 기본 정보 수집'")
        @Convert(converter = StringConverter::class)
        var custom: List<String>? = null,
        @Column(columnDefinition = "mediumText COMMENT '평가 요소'")
        @Convert(converter = ElementConverter::class)
        var elements: List<SurveyRequest>,
        @Column(columnDefinition = "DATETIME COMMENT '유효기간(만료)'")
        var endDate: LocalDateTime,
        @Column(columnDefinition = "varchar(255) COMMENT '설문지 제목'")
        var title: String,
        @Column(columnDefinition = "mediumText COMMENT '설문지 설명'")
        var content: String,
        @Column(columnDefinition = "bigint COMMENT '서비스 아이디'")
        val projectId: Long
)