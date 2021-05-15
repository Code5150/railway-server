package com.code5150.dto

import com.code5150.dao.GaugeEntity

data class GaugeDTO(val id: Int, val number: String, val data: String){
    constructor(gauge: GaugeEntity): this(gauge.id.value, gauge.number, gauge.data)
}
