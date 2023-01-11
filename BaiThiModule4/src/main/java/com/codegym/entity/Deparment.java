package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "deparments")
public class Deparment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String nameDeparment;

    public Deparment(Integer id, String nameDeparment) {
        this.id = id;
        this.nameDeparment = nameDeparment;
    }

    public Deparment(String nameDeparment) {
        this.nameDeparment = nameDeparment;
    }

    public Deparment() {
    }

    @Id
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

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }

    @ManyToMany(mappedBy = "staff")
    private Set<Staff> staff;
}
