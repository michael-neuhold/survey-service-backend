package clc.outbound

import clc.shared.SurveyResponse
import org.springframework.data.mongodb.repository.MongoRepository

interface SurveyResponseRepository : MongoRepository<SurveyResponse, String> {
    fun findAllByRelatesTo(relatesTo: String): List<SurveyResponse>
}