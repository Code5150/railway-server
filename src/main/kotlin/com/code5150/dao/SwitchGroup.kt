package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object SwitchGroup : IntIdTable("switch_group") {
    val name = varchar("name", 50)
}

class SwitchGroupEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<SwitchGroupEntity>(SwitchGroup)

    var name by SwitchGroup.name

    override fun toString() = "Группа стр. переводов $name"
}