package com.abhizer0.employee;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository empRepo;


    public void saveEmployee(Employee employee){
            empRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return empRepo.findAll();
    }

    public List<Employee> findAllEmployeesByCompany(Integer companyId) {
        return empRepo.findAllByCompanyId(companyId);
    }
}
