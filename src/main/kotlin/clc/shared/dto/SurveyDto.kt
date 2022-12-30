package clc.shared.dto

import clc.shared.Question

data class SurveyDto(
        val id: String,
        val author: String,
        val title: String,
        val description: String,
        val questions: List<Question>,
        val responses: List<String>)