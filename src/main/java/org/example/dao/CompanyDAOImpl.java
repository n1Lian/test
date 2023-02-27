package org.example.dao;

import org.example.company.ITCompany;
import org.example.company.employee.Developer;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.example.company.employee.PM;
import org.example.dao.repository.CompanyRepository;
import org.example.dao.repository.DeveloperRepository;
import org.example.dao.repository.EmployeeRepository;
import org.example.dao.repository.PMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PMRepository pmRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long create(ITCompany company) {
        ITCompany savedCompany = companyRepository.save(company);
        return savedCompany.getId();
    }

    @Override
    public ITCompany find(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void addDeveloper(Developer developer) {
        developerRepository.save(developer);
    }

    @Override
    public void addPM(PM pm) {
        pmRepository.save(pm);
    }

    @Override
    public List<Employee<ITRole>> getEmployeesByRole(ITRole role, long company_id) {
        ITCompany company = find(company_id);
        return employeeRepository.findByRoleAndCompanyQ(role, company);
    }

    @Override
    public Employee<ITRole> findEmployee(long employee_id) {
        Employee<ITRole> employee = entityManager.find(Developer.class, employee_id);
        entityManager.detach(employee);
        return employee;
    }
}
