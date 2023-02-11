package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.CompanyDTO;
import org.example.company.employer.Developer;
import org.example.company.employer.Employer;
import org.example.company.employer.ITRole;
import org.example.company.employer.PM;
import org.example.service.CompanyService;
import org.example.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public CompanyDTO getCompany() {
        return CompanyDTO.from(companyService.getCompany());
    }

    @PostMapping("/employers/developers")
    public ResponseEntity addEmployer(@RequestBody Developer developer) {
        companyService.addDeveloper(developer);
        log.info("Add new developer");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/employers/PMs")
    public ResponseEntity addEmployer(@RequestBody PM pm) {
        companyService.addPM(pm);
        log.info("Add new PM");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employer<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("Get employer by index = " + index);
        try {
            return ResponseEntity.ok(companyService.getEmployerByIndex(index));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employers/find")
    public ResponseEntity<List<Employer<ITRole>>> getEmployerByRole(@RequestParam(name = "role") ITRole role) {
        log.info("Get employer by role = " + role);
        try {
            return ResponseEntity.ok(companyService.getEmployerByRole(role));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
