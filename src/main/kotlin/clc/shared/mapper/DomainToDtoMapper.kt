package clc.shared.mapper

import clc.shared.Survey
import clc.shared.User
import clc.shared.dto.SurveyDto
import clc.shared.dto.UserDto

sealed class DomainToDtoMapper {

    companion object {
        fun fromSurveyList(source: List<Survey>): List<SurveyDto> {
            return source.map { s -> fromSurvey(s) }.toList()
        }

        fun fromSurvey(source: Survey): SurveyDto {
            return SurveyDto(
                    if (source.isIdInitialized()) source.id else "",
                    source.author,
                    source.title,
                    source.description,
                    source.questions,
                    source.responses)
        }

        fun fromUserList(source: List<User>): List<UserDto> {
            return source.map { u -> fromUser(u) }.toList()
        }

        fun fromUser(source: User): UserDto {
            return UserDto(source.id, source.userName, source.firstName, source.lastName, source.email)
        }
    }

}
