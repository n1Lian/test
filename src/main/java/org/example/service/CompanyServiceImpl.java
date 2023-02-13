package org.example.service;

import org.example.company.ITCompany;
import org.example.company.employer.Developer;
import org.example.company.employer.Employer;
import org.example.company.employer.ITRole;
import org.example.company.employer.PM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private ITCompany company;

    @Override
    public ITCompany getCompany() {
        return company;
    }

    @Override
    public void addDeveloper(Developer developer) {
        company.getEmployers().add(developer);
    }

    @Override
    public void addPM(PM pm) {
        company.getEmployers().add(pm);
    }

    @Override
    public Employer<ITRole> getEmployerByIndex(int index) {
        return company.getEmployers().get(index);
    }

    @Override
    public List<Employer<ITRole>> getEmployerByRole(ITRole role) {
        return company.getEmployers().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
    }
}
