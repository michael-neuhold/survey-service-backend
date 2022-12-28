package clc.shared

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.NoArgsConstructor

@NoArgsConstructor
class SurveyPostRequestDto(@JsonProperty("name") val name: String)