package clc.shared

import lombok.Builder
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Builder
@Document
data class Survey(
        val author: String,
        val title: String,
        val description: String,
        val questions: List<Question>,
        val responses: List<String>) {

    @MongoId
    lateinit var id: String

    fun isIdInitialized() = ::id.isInitialized

}
