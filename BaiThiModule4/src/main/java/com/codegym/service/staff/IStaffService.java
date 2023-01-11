package com.codegym.service.staff;


import com.codegym.dto.StaffDto;
import com.codegym.entity.Staff;
import com.codegym.service.IGeneralService;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IStaffService extends IGeneralService<StaffDto> {

    List<Staff> findByOrderByAgeAsc();

    List<Staff> findByLastNameOrderBySeatNumberAsc(String name);
}
