package org.example.dao;

import org.example.company.ITCompany;
import org.example.company.employee.*;

import java.util.List;

public interface CompanyDAO {
    Integer create(ITCompany itCompany);
    ITCompany find(int id);
    void addDeveloper(Developer developer);
    void addPM(PM pm);
    List<Employee<ITRole>> getEmployeesByRole(ITRole role, int company_id);
    Employee<ITRole> findEmployee(int employee_id);
}
