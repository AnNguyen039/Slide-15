package com.codegym.dto;

import com.codegym.entity.Deparment;
import com.codegym.entity.Staff;

import javax.persistence.ManyToMany;
import java.util.Set;

public class DeparmentDto {
    private Integer id;
    private String nameDeparment;

    private Set<Deparment> deparment;

    public DeparmentDto() {
    }

    @ManyToMany(mappedBy = "staff")
    private Set<Staff> staff;

    public DeparmentDto(Integer id, String nameDeparment, Set<Deparment> deparment) {
        this.id = id;
        this.nameDeparment = nameDeparment;
        this.staff = staff;
    }

    public DeparmentDto(String brandName, Set<Deparment> deparment) {
        this.nameDeparment = nameDeparment;
        this.staff = staff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameDeparment() {
        return nameDeparment;
    }

    public void setNameDeparment(String nameDeparment) {
        this.nameDeparment = nameDeparment;
    }

    public Set<Deparment> getDeparment() {
        return deparment;
    }

    public void setDeparment(Set<Deparment> deparment) {
        this.deparment = deparment;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }
}
