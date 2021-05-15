package com.code5150.dto

import com.code5150.dao.StaffEntity

data class StaffDTO(val name: String, val surname: String, val patronymic: String, val position: String){
    constructor(staff: StaffEntity) : this(staff.name, staff.surname, staff.patronymic, staff.position)
}
