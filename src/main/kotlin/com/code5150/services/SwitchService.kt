package com.code5150.services

import com.code5150.dao.Switch
import com.code5150.dao.SwitchEntity
import com.code5150.dao.SwitchGroup
import com.code5150.dao.SwitchGroupEntity
import com.code5150.dto.SwitchDTO
import com.code5150.dto.SwitchGroupDTO
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.transactions.transaction

class SwitchService {
    fun selectAll(): Iterable<SwitchDTO> = transaction {
        SwitchEntity.all().map { SwitchDTO(it) }
    }

    fun selectAllGroups(): Iterable<SwitchGroupDTO> = transaction {
        SwitchGroupEntity.all().map { SwitchGroupDTO(it) }
    }

    fun findById(id: Int): SwitchEntity = transaction {
        SwitchEntity.findById(id)!!
    }

    fun findByGroupId(groupId: Int): Iterable<SwitchDTO> = transaction {
        SwitchEntity.find { Switch.switchGroup eq EntityID(groupId, SwitchGroup)}.map { SwitchDTO(it) }
    }
}