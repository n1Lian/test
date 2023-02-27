package org.example.dao;

import org.example.company.ITCompany;
import org.example.company.employee.Developer;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.example.company.employee.PM;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer create(ITCompany company) {
        entityManager.persist(company);
        entityManager.flush();
        return company.getId();
    }

    @Override
    public ITCompany find(int id) {
        return entityManager.find(ITCompany.class, id);
    }

    @Override
    public void addDeveloper(Developer developer) {
        entityManager.persist(developer);
    }

    @Override
    public void addPM(PM pm) {
        entityManager.persist(pm);
    }

    @Override
    public List<Employee<ITRole>> getEmployeesByRole(ITRole role, int company_id) {
        return null;
    }

    @Override
    public Employee<ITRole> findEmployee(int employee_id) {
        Employee<ITRole> employee = entityManager.find(Developer.class, employee_id);
        entityManager.detach(employee);
        return employee;
    }
}
