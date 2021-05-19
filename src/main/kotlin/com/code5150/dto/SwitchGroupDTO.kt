package com.code5150.dto

import com.code5150.dao.SwitchGroupEntity

data class SwitchGroupDTO(val id: Int, val name: String) {
    constructor(group: SwitchGroupEntity): this(group.id.value, group.name)
}
