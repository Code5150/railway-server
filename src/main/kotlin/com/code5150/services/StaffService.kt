package com.code5150.services

import com.code5150.dao.Staff
import com.code5150.dao.StaffEntity
import com.code5150.dto.StaffDTO
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction

class StaffService {
    fun selectAll(): Iterable<StaffDTO> = transaction {
        StaffEntity.all().map{StaffDTO(it)}
    }

    fun checkCredentials(login: String, password: String): Boolean = transaction {
        !StaffEntity.find { (Staff.login eq login) and (Staff.password eq password) }.empty()
    }
}