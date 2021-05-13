package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Measure : IntIdTable("measure") {
    val parameterValue = integer("parameter_value")
    val parameter = reference("parameter_id", Parameter)
    val measurePoint = reference("measure_point_id", MeasurePoint)
}

class MeasureEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<MeasureEntity>(Measure)

    var parameterValue by Measure.parameterValue
    var parameter by ParameterEntity referencedOn Measure.parameter
    var measurePoint by MeasurePointEntity referencedOn Measure.measurePoint
}