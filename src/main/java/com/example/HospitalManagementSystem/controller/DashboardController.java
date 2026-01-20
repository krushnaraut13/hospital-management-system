package com.example.HospitalManagementSystem.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.service.DashboardService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/summary")
    public Map<String, Object> getDashboardSummary( @RequestHeader("role") String role){
    	AuthorizationUtil.checkRole(role, "ADMIN");
    	return dashboardService.getSummary();
    }
}
