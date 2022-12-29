package clc.shared.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.NoArgsConstructor

@NoArgsConstructor
class CreateSurveyRequestDto(@JsonProperty("name") val name: String)