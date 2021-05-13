package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Switch : IntIdTable("switch") {
    val name = varchar("name", 50)
    val rail = varchar("rail", 50)
    val facing = varchar("facing", 50)
    val cross = varchar("cross", 50)
    val switchGroup = reference("switch_group_id", SwitchGroup)
}

class SwitchEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<SwitchEntity>(Switch)

    var switchGroup by SwitchGroupEntity referencedOn Switch.switchGroup
    var name by Switch.name
    var rail by Switch.rail
    var facing by Switch.facing
    var cross by Switch.cross

    override fun toString() = "Стр. перевод $name, группа ${switchGroup.name}"
}