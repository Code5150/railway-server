package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Parameter : IntIdTable("parameter") {
    val minValue = integer("min_value")
    val maxValue = integer("max_value")
    val unitName = varchar("unit_name", 50)
    val parameterName = varchar("name", 50)
}

class ParameterEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<ParameterEntity>(Parameter)

    var minValue by Parameter.minValue
    var maxValue by Parameter.maxValue
    var unitName by Parameter.unitName
    var parameterName by Parameter.parameterName

    override fun toString() = "$parameterName: от $minValue $unitName до $maxValue $unitName"
}