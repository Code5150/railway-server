package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Gauge: IntIdTable("gauge"){
    val number = varchar("number", 50)
    val data = varchar("data", 100)
}

class GaugeEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<GaugeEntity>(Gauge)

    var number by Gauge.number
    var data by Gauge.data

    override fun toString() = "Путевой шаблон №$number: $data"
}