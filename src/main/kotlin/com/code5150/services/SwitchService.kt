package com.code5150.services

import com.code5150.dao.SwitchEntity
import com.code5150.dto.SwitchDTO
import org.jetbrains.exposed.sql.transactions.transaction

class SwitchService {
    fun selectAll(): Iterable<SwitchDTO> = transaction {
        SwitchEntity.all().map { SwitchDTO(it) }
    }

    fun findById(id: Int): SwitchEntity = transaction {
        SwitchEntity.findById(id)!!
    }
}