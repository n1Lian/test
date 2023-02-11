package org.example.service;

import org.example.company.ITCompany;
import org.example.company.employer.*;

import java.util.List;

public interface CompanyService {
    ITCompany getCompany();

    void addDeveloper(Developer developer);

    void addPM(PM pm);

    Employer<ITRole> getEmployerByIndex(int index);

    List<Employer<ITRole>> getEmployerByRole(ITRole role);
}
