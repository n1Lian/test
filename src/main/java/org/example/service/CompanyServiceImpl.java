package org.example.service;

import org.example.company.ITCompany;
import org.example.company.employee.Developer;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.example.company.employee.PM;
import org.example.dao.CompanyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

// Проблемы:

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    @Transactional
    public Long createCompany(ITCompany company) {
        return companyDAO.create(company);
    }

    @Override
    @Transactional
    public ITCompany getCompany(long company_id) {
        return companyDAO.find(company_id);
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer, long company_id) {
        developer.setCompany(getCompany(company_id));
        companyDAO.addDeveloper(developer);
    }

    @Override
    @Transactional
    public void addPM(PM pm, long company_id) {
        pm.setCompany(getCompany(company_id));
        companyDAO.addPM(pm);
    }

    @Override
    @Transactional
    public Employee<ITRole> getEmployeeById(long id) {
        return companyDAO.findEmployee(id);
    }

    @Override
    @Transactional
    public List<Employee<ITRole>> getEmployeeByRole(ITRole role, long company_id) {
        return getCompany(company_id).getEmployees().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
    }
}
