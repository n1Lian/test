package org.example.dao.repository;

import org.example.company.ITCompany;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<ITCompany, Long> {

}
