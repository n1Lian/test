package org.example.company.employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "pms")
public class PM extends Employee<ITRole> {
    public PM() {

    }
    public PM(String name, int age) {
        super(name, age, ITRole.PM);
    }

    @Override
    public void work(){
        System.out.println(this.getName() + " is managing project");
    }
}
