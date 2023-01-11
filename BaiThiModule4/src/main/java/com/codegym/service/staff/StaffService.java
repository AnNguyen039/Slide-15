package com.codegym.service.staff;

import com.codegym.dto.StaffDto;
import com.codegym.entity.Staff;
import com.codegym.repository.IStaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService implements IStaffService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IStaffRepository staffRepository;

    @Override
    public List<StaffDto> findAll() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.parallelStream()
                .map(staff -> modelMapper.map(staff, StaffDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StaffDto findById(Integer id) {
        Staff staff = staffRepository.findById(id).get();
        return modelMapper.map(staff, StaffDto.class);
    }

    @Override
    public void save(StaffDto staffDto) {
        Staff staff = modelMapper.map(staffDto, Staff.class);
        staffRepository.save(staff);
    }

    @Override
    public void remove(Integer id) {
        staffRepository.deleteById(id);
    }


    @Override
    public List<Staff> findByOrderByAgeAsc() {
        return null;
    }

    @Override
    public List<Staff> findByLastNameOrderBySeatNumberAsc(String name) {
        return staffRepository.findByOrderByAgeAsc();
    }

}
