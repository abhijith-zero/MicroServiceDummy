package com.abhizer0.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final  EmployeeService  employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees(){
        return ResponseEntity.ok((employeeService.findAllEmployee()));
    }
    @GetMapping("/company/{company-id}")
    public ResponseEntity<List<Employee>> findAllEmployees(@PathVariable("company-id") Integer companyId){
        return ResponseEntity.ok((employeeService.findAllEmployeesByCompany(companyId)));
    }
}

