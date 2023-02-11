package org.example.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.company.employer.Employer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EntityManager<T extends Employer> {
    private List<T> entities;

    //@SuppressWarnings("unchecked");
    public EntityManager() {
        this.entities = new ArrayList<>();
    }

    public int getSize() {
        return entities.size();
    }

    public List<T> getEntities() {
        return entities;
    }
}
