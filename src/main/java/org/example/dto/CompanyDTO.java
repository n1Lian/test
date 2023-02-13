package org.example.dto;


import lombok.Data;
import org.example.company.ITCompany;
import org.example.company.employer.Employer;
import org.example.company.employer.ITRole;

import java.util.List;

@Data
public class CompanyDTO {
    private String name;
    private Employer<ITRole> director;
    private List<Employer<ITRole>> employers;

    public static CompanyDTO from(ITCompany company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName(company.getName());
        companyDTO.setDirector(company.getDirector());
        companyDTO.setEmployers(company.getEmployers());
        return companyDTO;
    }
}
