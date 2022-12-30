package clc.shared.dto

data class CreateSurveyResponseRequestDto(
        val author: String,
        val relatesTo: String,
        val answers: List<String>)