package clc.shared.dto

import clc.shared.Question
import lombok.NoArgsConstructor

@NoArgsConstructor
data class CreateSurveyRequestDto(
        val author: String,
        val title: String,
        val description: String,
        val questions: List<Question>)