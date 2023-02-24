package org.example.dto;

import lombok.Data;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;

@Data
public class ITEmployeeDTO {
    private int id;
    private String name;
    private int age;
    private ITRole role;

    public static ITEmployeeDTO from(Employee<ITRole> employee) {
        ITEmployeeDTO dto = new ITEmployeeDTO();
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setRole(employee.getRole());
        dto.setId(employee.getId());
        return dto;
    }

    public Employee<ITRole> toEmployee() {
        Employee<ITRole> employee = new Employee<>();
        employee.setId(this.id);
        employee.setName(this.name);
        employee.setAge(this.age);
        employee.setRole(this.role);
        return employee;
    }
}
