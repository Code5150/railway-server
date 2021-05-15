package com.code5150.services

import com.code5150.dao.GaugeEntity
import com.code5150.dao.Inspection
import com.code5150.dao.StaffEntity
import com.code5150.dao.SwitchEntity
import com.code5150.dto.InspectionDTO
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

class InspectionService {
    fun insert(i: InspectionDTO): Int = transaction {
        Inspection.insertAndGetId {
            it[inspectionDate] = i.date
            it[switch] = EntityID(i.switchId, SwitchEntity.table)
            it[staff] = EntityID(i.staffId, StaffEntity.table)
            it[gauge] = EntityID(i.gaugeId, GaugeEntity.table)
        }.value
    }
}