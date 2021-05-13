package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object MeasurePoint : IntIdTable("measure_point") {
    val name = varchar("name", 50)
}

class MeasurePointEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<MeasurePointEntity>(MeasurePoint)

    var name by MeasurePoint.name

    override fun toString() = "Точка промера $name"
}