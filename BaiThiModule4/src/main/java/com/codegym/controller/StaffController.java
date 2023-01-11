package com.codegym.controller;

import com.codegym.dto.StaffDto;
import com.codegym.entity.Staff;
import com.codegym.service.staff.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class StaffController {

    @Autowired
    private IStaffService staffService;



    @GetMapping ("/list-staff")
    public ModelAndView viewDashboard(){
        List<Staff> staff = staffService.findByLastNameOrderBySeatNumberAsc(String.valueOf(Sort.by(Sort.Direction.ASC, "age")));
        ModelAndView modelAndView = new ModelAndView("Staff/list");
        modelAndView.addObject("staff", staff);
        return modelAndView;

    }

    private ModelAndView showListStaff(int i, String keyword) {
        return null;
    }


    @GetMapping("/edit-staff/{id}")
    private ModelAndView editStaffById(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("staff/edit");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;
    }

    @GetMapping("/view-staff/{id}")
    private ModelAndView viewStaffById(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("staff/view");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-staff")
    private ModelAndView updateStaff(StaffDto staffDto) {
        staffService.save(staffDto);
        return new ModelAndView("redirect:/admin/list-staff");
    }

    @GetMapping("/delete-staff/{id}")
    private ModelAndView removestaff(@PathVariable(value = "id") Integer id) {
        staffService.remove(id);
        return new ModelAndView("redirect:/admin/list-staff");
    }

    @GetMapping("/create-staff")
    private ModelAndView createStaff() {
        ModelAndView modelAndView = new ModelAndView("staff/create");
        StaffDto stafftDto = new StaffDto();
        modelAndView.addObject("staff", stafftDto);
        return modelAndView;
    }

    @PostMapping("/create-staff/save")
    private ModelAndView saveStaff(StaffDto staffDto) {
        staffService.save(staffDto);
        return new ModelAndView("redirect:/admin/list-staff");
    }
    List<Staff> staff = staffService.findByLastNameOrderBySeatNumberAsc(String.valueOf(Sort.by(Sort.Direction.ASC, "age")));
}