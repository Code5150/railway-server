package com.code5150.dto

import com.code5150.dao.InspectionEntity
import java.time.LocalDateTime

data class InspectionDTO(val date: LocalDateTime, val staffId: Int, val gaugeId: Int, val switchId: Int) {
    constructor(i: InspectionEntity): this(i.inspectionDate, i.staff.id.value, i.gauge.id.value, i.switch.id.value)
}