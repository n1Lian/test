package org.example.company;

import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "companies")
public class ITCompany extends EmployeeManager<Employee<ITRole>> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Employee<ITRole> director;

    public ITCompany() {

    }

    public ITCompany(String companyName) {
        super();
        this.name = companyName;
    }

    public void startWork(){
        getEmployees().forEach(worker -> {
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

    public Employee<ITRole> getDirector(){
        return director;
    }

    public void setDirector(Employee<ITRole> director) {
        this.director = director;
    }

    public Long getId() {
        return id;
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
