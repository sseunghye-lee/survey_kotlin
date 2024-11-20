package com.seung.survey_kotlin.commons.dto.request.survey

import com.seung.survey_kotlin.commons.enums.EvaluationItem
import com.seung.survey_kotlin.commons.enums.UIType


data class SurveyRequest(
        var item: EvaluationItem = EvaluationItem.CLEAN,
        var title: String = "",
        var uiType: UIType = UIType.RADIO
) {
}