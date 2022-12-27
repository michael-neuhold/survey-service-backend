package clc.shared

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Survey (@Id val id: Int,
              val name: String)
