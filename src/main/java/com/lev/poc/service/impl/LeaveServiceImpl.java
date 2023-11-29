package com.lev.poc.service.impl;

import com.lev.poc.entity.Department;
import com.lev.poc.entity.Employee;
import com.lev.poc.entity.Leave;
import com.lev.poc.exception.RecordNotFoundException;
import com.lev.poc.repository.DepartmentRepository;
import com.lev.poc.repository.EmployeeRepository;
import com.lev.poc.repository.LeaveRepository;
import com.lev.poc.service.LeaveService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    Logger LOGGER = LoggerFactory.getLogger(LeaveServiceImpl.class);


    /*@PostConstruct
    public void initDB() {
        List<Leave> leaves = List.of(new Leave("CASUAL","4","10","6"),
                new Leave("CASUAL","5","10","5"),
                new Leave("CASUAL","2","10","8"),
                new Leave("SICK","1","10","9"),
                new Leave("CASUAL","0","10","10"),
                new Leave("CASUAL","4","10","6"),
                new Leave("CASUAL","6","10","4"),
                new Leave("CASUAL","2","10","8"),
                new Leave("CASUAL","10","10","0"));

        leaveRepository.saveAll(leaves);
    }*/


    /*@PostConstruct
    public void initDB() {
        List<Department> dept = List.of(new Department("DEVELOPER"),
                new Department("TESTING"),
                new Department("DEVOPS"));

        departmentRepository.saveAll(dept);

        List<Leave> leaves = List.of(new Leave("CASUAL","3","10","7"));

        leaveRepository.saveAll(leaves);

        // Define the salary range (adjust these values as needed)
        double minSalary = 30000.0;
        double maxSalary = 80000.0;

        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random salary within the specified range
        //double randomSalary = minSalary + (maxSalary - minSalary) * random.nextDouble();

        // Round the salary to the nearest integer
        //int roundedSalary = (int) Math.round(randomSalary);

        List<Employee> employees = IntStream.rangeClosed(1, 10)
                .mapToObj(e -> new Employee(e, "sample_first" + e, "sample_last" + e, "temp_" + e + "poc.com", (int) Math.round(minSalary + (maxSalary - minSalary) * random.nextDouble()), "software engg", new Department(1, "DEVELOPER"), new Leave(1, "CASUAL","3","10","7")))
                .collect(Collectors.toList());
        employeeRepository.saveAll(employees);
    }*/

    /**
     * Fetch Leave List against an EmployeeID from the DB.
     * @return
     */
    public Leave getLeaveDetailsById(int id) throws RecordNotFoundException {
        LOGGER.info("In LeaveServiceImpl - to fetch Leave Details from repository");
        Optional<Leave> leave = leaveRepository.findById(id);

        System.out.println("isPresent > "+leave.isPresent());
        //System.out.println("leave.get > "+leave.get());
        if (leave.isPresent()) {
            return leave.get();
        } else {
            throw new RecordNotFoundException
                    ("No Leave record exist for given Employee id: " + id);
        }
    }
}
