package com.abhizer0.company;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository compRepo;


    public void saveCompany(Company company){
            compRepo.save(company);
    }

    public List<Company> findAllCompanies(){
        return compRepo.findAll();
    }
    public FullCompanyResponse findCompaniesWithEmployees(Integer companyId){
        var schoocompanyl= compRepo.findById(companyId)
                .orElse(
                    Company.builder().
                            build()
                );

    }
}
