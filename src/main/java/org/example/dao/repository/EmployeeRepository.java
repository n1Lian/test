package org.example.dao.repository;

import org.example.company.ITCompany;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee<ITRole>, Long> {
    List<Employee<ITRole>> findByRoleAndCompany(ITRole role, ITCompany company);
    List<Employee<ITRole>> findByRoleAndCompanyId(ITRole role, long company_id);

    @Query("select e from Employee e where e.role = :role and e.company = :company")
    List<Employee<ITRole>> findByRoleAndCompanyQ(ITRole role, ITCompany company);
}
