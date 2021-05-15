package com.code5150.services

import com.code5150.dao.GaugeEntity
import com.code5150.dto.GaugeDTO
import org.jetbrains.exposed.sql.transactions.transaction

class GaugeService {
    fun selectAll(): Iterable<GaugeDTO> = transaction {
        GaugeEntity.all().map { GaugeDTO(it) }
    }
}