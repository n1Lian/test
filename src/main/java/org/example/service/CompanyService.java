package org.example.service;

import org.example.company.ITCompany;
import org.example.company.employee.*;

import java.util.List;

public interface CompanyService {

    Long createCompany(ITCompany company);

    ITCompany getCompany(long id);

    void addDeveloper(Developer developer, long company_id);

    void addPM(PM pm, long company_id);

    Employee<ITRole> getEmployeeById(long id);

    List<Employee<ITRole>> getEmployeeByRole(ITRole role, long company_id);
}
