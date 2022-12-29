package clc.shared.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDto(@JsonProperty("id") val id: Long?,
                   @JsonProperty("userName") val userName: String,
                   @JsonProperty("firstName") val firstName: String,
                   @JsonProperty("lastName") val lastName: String,
                   @JsonProperty("email") val email: String)
