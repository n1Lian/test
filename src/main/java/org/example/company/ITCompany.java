package org.example.company;

import org.example.company.employer.Employer;
import org.example.company.employer.ITRole;
import org.example.company.employer.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("CompanyComponent")
public class ITCompany extends EntityManager<Employer<ITRole>> {
    private String name;
    private Employer<ITRole> director;

    public ITCompany(String companyName) {
        super();
        this.name = companyName;
    }

    public void startWork(){
        getEntities().forEach(worker -> {
            worker.work();
            System.out.println(worker.getName() + "is " + worker.getRole());
        });
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Employer<ITRole> getDirector(){
        return director;
    }

    public void setDirector(Employer<ITRole> director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "ITCompany{" +
                "name = \'" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ITCompany company = (ITCompany) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }

}
