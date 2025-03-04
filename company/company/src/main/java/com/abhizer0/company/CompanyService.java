package com.abhizer0.company;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.abhizer0.company.client.EmployeeClient;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository compRepo;
    
    
    private final EmployeeClient empClient;



    public void saveCompany(Company company){
            compRepo.save(company);
    }

    public List<Company> findAllCompanies(){
        return compRepo.findAll();
    }
    public FullCompanyResponse findCompaniesWithEmployees(Integer companyId){
        if (empClient == null) {
            throw new IllegalStateException("EmployeeClient is not initialized!");
        }
        var company= compRepo.findById(companyId)
                .orElse(
                    Company.builder()
                            .companyName("NOT_Found")
                            .email("NOT_FOUND")
                            .build()
                );
        var employees = empClient.findAllEmployeesByCompany(companyId);
        return FullCompanyResponse.builder()
        .companyName(company.getCompanyName())
        .email(company.getEmail())
        .employees(employees)
        .build();


    }
}
