package org.example.service;

import org.example.company.ITCompany;
import org.example.company.employee.*;

import java.util.List;

public interface CompanyService {

    Integer createCompany(ITCompany company);

    ITCompany getCompany(int id);

    void addDeveloper(Developer developer, int company_id);

    void addPM(PM pm, int company_id);

    Employee<ITRole> getEmployeeById(int id);

    List<Employee<ITRole>> getEmployeeByRole(ITRole role, int company_id);
}
