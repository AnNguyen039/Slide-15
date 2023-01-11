package com.codegym.dto;

import com.codegym.entity.Staff;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

public class StaffDto {
    private Integer id;
    private String nameStaff;
    private String ageStaff;
    private String department;

    public StaffDto(Integer id, String nameStaff, String ageStaff, String department) {
        this.id = id;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.department = department;
    }



    public StaffDto(String nameStaff, String ageStaff, String department) {
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.department = department;
    }

    public StaffDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getAgeStaff() {
        return ageStaff;
    }

    public void setAgeStaff(String ageStaff) {
        this.ageStaff = ageStaff;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
