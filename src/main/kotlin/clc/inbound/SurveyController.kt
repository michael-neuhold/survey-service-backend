package clc.inbound

import clc.outbound.SurveyRepository
import clc.shared.Survey
import clc.shared.dto.CreateSurveyRequestDto
import clc.shared.dto.SurveyDto
import clc.shared.mapper.DomainToDtoMapper
import clc.shared.mapper.DtoToDomainMapper
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = ["*"])
class SurveyController(private val surveyRepository: SurveyRepository) {

    @GetMapping
    fun getAllSurveys(): ResponseEntity<List<SurveyDto>> {
        val surveys = surveyRepository.findAll();
        return ResponseEntity.ok(DomainToDtoMapper.fromSurveyList(surveys));
    }

    @GetMapping("/{id}")
    fun getOneSurvey(@PathVariable("id") id: String): ResponseEntity<SurveyDto> {
        val survey = surveyRepository.findOneById(ObjectId(id));
        return ResponseEntity.ok(DomainToDtoMapper.fromSurvey(survey));
    }

    @PostMapping
    fun postSurvey(@RequestBody survey: CreateSurveyRequestDto): ResponseEntity<Survey> {
        val createdSurvey = surveyRepository.save(DtoToDomainMapper.from(survey));
        return ResponseEntity.ok(createdSurvey);
    }

}