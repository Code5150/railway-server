package com.code5150.services

import com.code5150.dao.StaffEntity
import com.code5150.dto.StaffDTO
import org.jetbrains.exposed.sql.transactions.transaction

class StaffService {
    public fun selectAll(): Iterable<StaffDTO> = transaction {
        StaffEntity.all().map{StaffDTO(it)}
    }
}