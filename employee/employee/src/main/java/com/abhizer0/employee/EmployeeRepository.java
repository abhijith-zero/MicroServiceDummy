package com.abhizer0.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findAllByCompanyId(Integer companyId);

}