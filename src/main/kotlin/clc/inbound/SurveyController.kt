package clc.inbound

import clc.outbound.SurveyRepository
import clc.shared.Survey
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/survey")
class SurveyController(private val surveyRepository: SurveyRepository) {

    @GetMapping
    fun getAllSurveys(): ResponseEntity<List<Survey>> {
        val surveys = surveyRepository.findAll();
        println("surveys: " + surveys);
        return ResponseEntity.ok(surveys);
    }

    @GetMapping("/{id}")
    fun getOneSurvey(@PathVariable("id") id: String): ResponseEntity<Survey> {
        val survey = surveyRepository.findOneById(ObjectId(id));
        return ResponseEntity.ok(survey);
    }

    @PostMapping
    fun postSurvey(@RequestBody survey: Survey): ResponseEntity<Survey> {
        println("create survey: " + survey);
        val createdSurvey = surveyRepository.save(survey);
        return ResponseEntity.ok(createdSurvey);
    }

}