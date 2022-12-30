package clc.shared

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.mongodb.core.mapping.MongoId

data class SurveyResponse(
        val author: String,
        val relatesTo: String,
        val answers: List<String>) {

    @MongoId
    lateinit var id: String

    @JsonIgnore
    fun isIdInitialized() = ::id.isInitialized

}