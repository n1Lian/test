package org.example.dao;

import org.example.company.ITCompany;
import org.example.company.employee.*;

import java.util.List;
import java.util.Optional;

public interface CompanyDAO {
    Long create(ITCompany itCompany);
    ITCompany find(long id);
    void addDeveloper(Developer developer);
    void addPM(PM pm);
    List<Employee<ITRole>> getEmployeesByRole(ITRole role, long company_id);
    Employee<ITRole> findEmployee(long employee_id);
}
