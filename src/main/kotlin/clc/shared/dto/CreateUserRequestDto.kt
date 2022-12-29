package clc.shared.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.NoArgsConstructor

@NoArgsConstructor
data class CreateUserRequestDto(@JsonProperty("userName") val userName: String,
                                @JsonProperty("firstName") val firstName: String,
                                @JsonProperty("lastName") val lastName: String,
                                @JsonProperty("email") val email: String)
