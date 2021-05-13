package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object Inspection : IntIdTable("inspection") {
    val inspectionDate = datetime("inspection_date")
    val staff = reference("staff_id", Staff)
    val switch = reference("switch_id", Switch)
    val gauge = reference("gauge_id", Gauge)
}

class InspectionEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<InspectionEntity>(Inspection)

    var inspectionDate by Inspection.inspectionDate
    var staff by StaffEntity referencedOn Inspection.staff
    var switch by SwitchEntity referencedOn Inspection.switch
    var gauge by GaugeEntity referencedOn Inspection.gauge

    //override fun toString() = "Осмотр $id, группа ${switchGroup.name}"
}