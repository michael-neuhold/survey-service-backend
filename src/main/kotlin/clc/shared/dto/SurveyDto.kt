package clc.shared.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class SurveyDto(@JsonProperty("id") val id: String,
                     @JsonProperty("name") val name: String)
