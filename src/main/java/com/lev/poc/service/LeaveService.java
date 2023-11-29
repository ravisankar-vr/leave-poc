package com.lev.poc.service;

import com.lev.poc.entity.Leave;
import com.lev.poc.service.impl.*;

import java.util.List;

public interface LeaveService {
    Leave getLeaveDetailsById(int id);
}
