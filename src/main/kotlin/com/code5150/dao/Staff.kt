package com.code5150.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Staff: IntIdTable("staff") {
    val name: Column<String> = varchar("name", 50)
    val surname: Column<String> = varchar("surname", 50)
    val patronymic: Column<String> = varchar("patronymic", 50)
    val login: Column<String> = varchar("login", 50)
    val password: Column<String> = varchar("password", 50)
    val position: Column<String> = varchar("position", 50)
}

class StaffEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<StaffEntity>(Staff)

    var name by Staff.name
    var surname by Staff.surname
    var patronymic by Staff.patronymic
    var login by Staff.login
    var password by Staff.password
    var position by Staff.position

    override fun toString() = "$surname $name $patronymic, $position"
}