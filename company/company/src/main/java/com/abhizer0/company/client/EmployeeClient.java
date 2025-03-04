package com.abhizer0.company.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abhizer0.company.Employee;

@FeignClient(name="employee-service", url="${application.config.employees-url}")
// @FeignClient(name="employee-service", url="http://localhost:8090/api/v1/employee")
public interface EmployeeClient{
    @GetMapping("/company/{company-id}")
    List<Employee> findAllEmployeesByCompany(@PathVariable("company-id")Integer companyId);     

}