package com.codegym.controller;


import com.codegym.dto.DeparmentDto;
import com.codegym.dto.StaffDto;
import com.codegym.service.deparment.IDeparmentService;
import com.codegym.service.deparment.IDeparmentService;
import com.codegym.service.staff.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class DeparmentController {

    @Autowired
    private IDeparmentService deparmentService;

    @GetMapping("/list-deparment")
    public ModelAndView showListDeparment(){
        ModelAndView modelAndView = new ModelAndView("deparment/list");
        modelAndView.addObject("deparments",deparmentService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit-deparment/{id}")
    private ModelAndView editDeaprmentById(@PathVariable(value = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView("deparment/edit");
        modelAndView.addObject("deparment",deparmentService.findById(id));
        return modelAndView ;
    }

    @PostMapping("/edit-deparment")
    private ModelAndView updateDeparment(DeparmentDto deparmentDto){
        deparmentService.save(deparmentDto);
        return new ModelAndView("redirect:/admin/list-deparment");
    }

    @GetMapping("/delete-deparment/{id}")
    private ModelAndView removeDeparment(@PathVariable(value = "id") Integer id){
        deparmentService.remove(id);
        return new ModelAndView("redirect:/admin/list-deparment");
    }

    @GetMapping("/create-Deparment")
    private ModelAndView createDeparment(){
        ModelAndView modelAndView = new ModelAndView("deparment/create");
        modelAndView.addObject("deparment",new DeparmentDto());
        return modelAndView;
    }

    @PostMapping("/create-deparment/save")
    private ModelAndView saveDeparment(DeparmentDto deparmentDto){
        deparmentService.save(deparmentDto);
        return new ModelAndView("redirect:/admin/list-deparment");
    }
}
