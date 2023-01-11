package com.codegym.repository;

import com.codegym.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeparmentRepository extends JpaRepository<Deparment,Integer> {
}
