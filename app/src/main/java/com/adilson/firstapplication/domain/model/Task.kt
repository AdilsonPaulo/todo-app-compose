package com.adilson.firstapplication.domain.model

import com.android.identity.util.UUID
import java.time.LocalDate

data class Task(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var annotation: String?,
    var creationDate: LocalDate,
    var endDate: LocalDate?,
    var isFinished: Boolean
) {
}