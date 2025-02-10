package com.abhizer0.company.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="employee-service", url="${application.config.employees-url}")
public interface EmployeeClient(){
    @GetMapping("/company/{company-id}")
    List<Employee> findAllEmployeesByCompany(@PathVariable("company-id")Integer companyId);

}