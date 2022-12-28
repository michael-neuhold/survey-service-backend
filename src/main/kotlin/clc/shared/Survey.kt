package clc.shared

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document
data class Survey (val name: String) {

    @MongoId
    lateinit var id: String

}
