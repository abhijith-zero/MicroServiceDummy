package com.abhizer0.company;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FullCompanyResponse {
    private String companyName;
    private String email;

    List<Employee> employees;


}
