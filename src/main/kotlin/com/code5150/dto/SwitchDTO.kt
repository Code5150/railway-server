package com.code5150.dto

import com.code5150.dao.SwitchEntity

data class SwitchDTO(val id: Int, val name: String, val switchGroupId: Int){
    constructor(switch: SwitchEntity): this(switch.id.value, switch.name, switch.switchGroup.id.value)
}
