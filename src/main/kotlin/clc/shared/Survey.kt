package clc.shared

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Builder
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Builder
@Document
data class Survey(
        val author: String,
        val title: String,
        val description: String,
        val questions: List<Question>) {

    @MongoId
    lateinit var id: String

    @JsonIgnore
    fun isIdInitialized() = ::id.isInitialized

}
