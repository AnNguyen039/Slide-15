package com.codegym.repository;

import com.codegym.entity.Staff;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStaffRepository extends JpaRepository<Staff,Integer> {
    @Query("select s from Staff s where concat(s.nameStaff,s.department) LIKE %?1%")
    Page<Staff> pageAll(String keyword, Pageable pageable);

    List<Staff> findByOrderByAgeAsc();
}