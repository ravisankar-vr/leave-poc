package com.lev.poc.repository;

import com.lev.poc.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

    /*@Query(nativeQuery = true, value = "Select * from ems.emp_leave where lv_id=?1")
    Optional<Leave> findByLeaveID(Integer id);*/
}
