package org.example.company;

import org.example.company.employer.Employer;

import java.util.ArrayList;
import java.util.List;

public class EmployerManager<T extends Employer> {
    private List<T> employers;

    //@SuppressWarnings("unchecked");
    public EmployerManager() {
        this.employers = new ArrayList<>();
    }

    public int getSize() {
        return employers.size();
    }

    public List<T> getEmployers() {
        return employers;
    }
}
