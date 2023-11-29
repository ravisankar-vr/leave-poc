package com.lev.poc.controller;

import com.lev.poc.entity.Leave;
import com.lev.poc.service.LeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    Logger LOGGER = LoggerFactory.getLogger(LeaveController.class);

    @GetMapping("/leaves/{leaveId}")
    public Leave getEmployeeLeave(@PathVariable("leaveId") int leaveId) {

        LOGGER.info("In LeaveService RestController - to fetch Leave Details ");
        Leave leave =leaveService.getLeaveDetailsById(leaveId);

        /*System.out.println("leave.getLeaveType : "+leave.getLeaveType());
        System.out.println("leave.getBalanceLeaves : "+leave.getBalanceLeaves());
        System.out.println("leave.getTotalLeaves : "+leave.getTotalLeaves());
        System.out.println("leave.getTakenLeaves : "+leave.getTakenLeaves());*/
        return leave;
    }

}
