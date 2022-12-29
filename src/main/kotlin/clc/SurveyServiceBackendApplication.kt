package clc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
@EnableJpaRepositories
class SurveyServiceBackendApplication

fun main(args: Array<String>) {
    runApplication<SurveyServiceBackendApplication>(*args)
}
