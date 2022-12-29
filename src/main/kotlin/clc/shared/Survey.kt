package clc.shared

import lombok.Builder
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Builder
@Document
data class Survey (val name: String) {

    @MongoId
    lateinit var id: String

}
