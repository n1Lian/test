package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.CompanyDTO;
import org.example.company.employee.Developer;
import org.example.company.employee.Employee;
import org.example.company.employee.ITRole;
import org.example.company.employee.PM;
import org.example.dto.ITEmployeeDTO;
import org.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// Проблемы: Не реализован метод получения рабочего за ролью

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Integer createCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.createCompany(companyDTO.toCompany());
    }

    @GetMapping("/{id}")
    public CompanyDTO company(@PathVariable int id) {
        log.info("Log info: Send info about company");
        return CompanyDTO.from(companyService.getCompany(id));
    }

    @PostMapping("/{id}/employees/developers")
    public ResponseEntity addEmployee(
            @RequestBody Developer developer,
            @PathVariable(name = "id") int company_id) {
        companyService.addDeveloper(developer, company_id);
        log.info("Log info: Add new developer");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/employees/PMs")
    public ResponseEntity addEmployee(
            @RequestBody PM pm,
            @PathVariable(name = "id") int company_id) {
        companyService.addPM(pm, company_id);
        log.info("Log info: Add new PM");
        return ResponseEntity.ok().build();
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<ITEmployeeDTO> getEmployerById(@PathVariable int id) {
        try {
            ITEmployeeDTO employeeDTO = ITEmployeeDTO.from(companyService.getEmployeeById(id));
            log.info("Log info: Get employer by id = " + id);
            return ResponseEntity.ok(employeeDTO);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/employees/find")
    public ResponseEntity<List<ITEmployeeDTO>> getEmployerByRole(
            @RequestParam(name = "role") ITRole role,
            @PathVariable(name = "id") int company_id) {
        try {
        List<ITEmployeeDTO> result = companyService.getEmployeeByRole(role, company_id)
                .stream()
                .map(ITEmployeeDTO::from)
                .collect(Collectors.toList());
        log.info("Log info: Get employer by role = " + role);
        return ResponseEntity.ok(result);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
