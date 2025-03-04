package com.abhizer0.company;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        if (company == null ) {
            throw new RuntimeException("Invalid payload: Company is null or empty.");
        }
        service.saveCompany(company);
        return ResponseEntity.ok(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanies(){
        return ResponseEntity.ok((service.findAllCompanies()));
    }
   @GetMapping("with-employees/{company-id}")
   public ResponseEntity<FullCompanyResponse> findACompany(@PathVariable("company-id")Integer companyId){

    return ResponseEntity.ok(service.findCompaniesWithEmployees(companyId));
   }

}

