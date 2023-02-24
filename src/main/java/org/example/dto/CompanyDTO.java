package org.example.dto;


import lombok.Data;
import org.example.company.ITCompany;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

// Проблемы:
// -- Каст директора в методе from(), не соответствие типов


@Data
public class CompanyDTO {
    private String name;
    private ITEmployeeDTO director;
    private List<ITEmployeeDTO> employees;

    public static CompanyDTO from(ITCompany company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName(company.getName());
        companyDTO.setDirector(ITEmployeeDTO.from(company.getDirector()));
        List<ITEmployeeDTO> itEmployeeDTOList = company.getEmployees().stream()
                .map(ITEmployeeDTO::from)
                .collect(Collectors.toList());
        companyDTO.setEmployees(itEmployeeDTOList);
        return companyDTO;
    }

    public  ITCompany toCompany() {
        ITCompany company = new ITCompany(this.name);
        company.setDirector(this.director.toEmployee());
        company.getDirector().setCompany(company);

        if(!CollectionUtils.isEmpty(this.employees)) {
            List<Employee<ITRole>> employees = this.employees.stream()
                    .map(ITEmployeeDTO::toEmployee)
                    .peek(e -> e.setCompany(company))
                    .collect(Collectors.toList());
            company.getEmployees().addAll(employees);
        }
        return company;
    }
}
