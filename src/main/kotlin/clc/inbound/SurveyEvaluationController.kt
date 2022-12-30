package clc.inbound

import clc.shared.dto.SurveyResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("survey-evaluation")
@CrossOrigin(origins = ["*"])
class SurveyEvaluationController(private val surveyResponseController: SurveyResponseController) {

    private fun computeStats(surveyResponses: List<SurveyResponseDto>): List<Map<String, Int>> {
        val N = surveyResponses.maxOfOrNull { sr -> sr.answers.size } ?: 0
        val stats: List<MutableMap<String, Int>> = List(size = N) { mutableMapOf() }

        surveyResponses.forEach { surveyResponse ->
            surveyResponse.answers.forEachIndexed { index, answer -> stats[index].merge(answer, 1) { prev, one -> prev + one } }
        }
        return stats
    }

    @GetMapping("/{survey-id}/response-statistics")
    fun getResponseStatistics(@PathVariable("survey-id") surveyId: String): ResponseEntity<List<Map<String, Int>>> {
        val responses = surveyResponseController.getResponsesForSurvey(surveyId)
        val stats = computeStats(responses.body ?: emptyList())
        return ok(stats)
    }

}