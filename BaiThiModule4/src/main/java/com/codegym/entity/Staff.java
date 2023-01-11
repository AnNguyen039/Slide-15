package com.codegym.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name= "staffs")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameStaff;
    private String ageStaff;
    private String department;


    public Staff() {
    }

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

    public Staff(Integer id, String nameStaff, String ageStaff, String department) {
        this.id = id;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.department = department;

    }

    @ManyToMany
    @JoinTable(name = "staffs_deparments",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "staffs_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Staff> staff;
}
