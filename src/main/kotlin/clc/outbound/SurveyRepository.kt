package clc.outbound

import clc.shared.Survey
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface SurveyRepository : MongoRepository<Survey, String> {
    fun findOneById(id: ObjectId): Survey
    override fun deleteAll();
}