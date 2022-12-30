package clc.shared.dto

data class SurveyResponseDto(
        val id: String,
        val author: String,
        val relatesTo: String,
        val answers: List<String>)