package clc.shared.mapper

import clc.shared.Survey
import clc.shared.User
import clc.shared.dto.CreateSurveyRequestDto
import clc.shared.dto.CreateUserRequestDto

sealed class DtoToDomainMapper {

    companion object {
        fun from(source: CreateSurveyRequestDto): Survey {
            return Survey(
                    source.author,
                    source.title,
                    source.description,
                    source.questions,
                    emptyList())
        }

        fun from(source: CreateUserRequestDto): User {
            return User(source.userName, source.firstName, source.lastName, source.email)
        }
    }

}


