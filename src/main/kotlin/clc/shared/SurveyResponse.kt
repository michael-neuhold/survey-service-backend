package clc.shared

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document
data class SurveyResponse(
        val author: String,
        val relatesTo: String,
        val answers: List<String>) {

    @MongoId
    lateinit var id: String

    @JsonIgnore
    fun isIdInitialized() = ::id.isInitialized

}