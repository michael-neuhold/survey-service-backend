package clc.inbound

import clc.outbound.SurveyResponseRepository
import clc.shared.dto.CreateSurveyResponseRequestDto
import clc.shared.dto.SurveyResponseDto
import clc.shared.mapper.DomainToDtoMapper
import clc.shared.mapper.DtoToDomainMapper
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/survey-response")
@CrossOrigin(origins = ["*"])
class SurveyResponseController(private val surveyResponseRepository: SurveyResponseRepository) {

    @PostMapping
    fun createSurveyResponse(@RequestBody surveyResponse: CreateSurveyResponseRequestDto): ResponseEntity<String> {
        val createdSurveyResponse = surveyResponseRepository.save(DtoToDomainMapper.from(surveyResponse))
        return ok(if (createdSurveyResponse.isIdInitialized()) createdSurveyResponse.id else "")
    }

    @GetMapping("/{survey-id}")
    fun getResponsesForSurvey(@PathVariable("survey-id") surveyId: String): ResponseEntity<List<SurveyResponseDto>> {
        val responses = surveyResponseRepository.findAllByRelatesTo(surveyId)
        return ok(DomainToDtoMapper.fromSurveyResponseList(responses))
    }

}