package org.example.service;

import org.example.company.ITCompany;
import org.example.company.employee.Developer;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.example.company.employee.PM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

// Проблемы: Не реализован метод получения рабочего за ролью

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private ITCompany company;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Integer createCompany(ITCompany company) {
        entityManager.persist(company);
        entityManager.flush();
        return company.getId();
    }

    @Override
    public ITCompany getCompany(int company_id) {
        return entityManager.find(ITCompany.class, company_id);
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer, int company_id) {
        developer.setCompany(getCompany(company_id));
        entityManager.persist(developer);
    }

    @Override
    public void addPM(PM pm) {
        company.getEmployees().add(pm);
    }

    @Override
    @Transactional
    public Employee<ITRole> getEmployeeById(int id) {
        Developer developer = entityManager.find(Developer.class, id);
        entityManager.detach(developer);
        return developer;
    }

    @Override
    @Transactional
    public List<Employee<ITRole>> getEmployeeByRole(ITRole role, int company_id) {
        return getCompany(company_id).getEmployees().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
    }
}
