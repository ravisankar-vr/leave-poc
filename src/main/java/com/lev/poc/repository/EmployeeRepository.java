package com.lev.poc.repository;

import com.lev.poc.entity.Employee;
import com.lev.poc.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
