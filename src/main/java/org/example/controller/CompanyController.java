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
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public CompanyDTO getCompany() {
        log.info("Log info: Send info about company");
        return CompanyDTO.from(companyService.getCompany());
    }

    @RequestMapping(value = "/company/employers/developers", method = RequestMethod.POST)
    public ResponseEntity addEmployer(@RequestBody Developer developer) {
        companyService.addDeveloper(developer);
        log.info("Log info: Add new developer");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/company/employers/PMs", method = RequestMethod.POST)
    public ResponseEntity addEmployer(@RequestBody PM pm) {
        companyService.addPM(pm);
        log.info("Log info: Add new PM");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/company/employers/{index}", method = RequestMethod.GET)
    public ResponseEntity<Employer<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("Log info: Get employer by index = " + index);
        try {
            return ResponseEntity.ok(companyService.getEmployerByIndex(index));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/company/employers/find", method = RequestMethod.GET)
    public ResponseEntity<List<Employer<ITRole>>> getEmployerByRole(@RequestParam(name = "role") ITRole role) {
        log.info("Log info: Get employer by role = " + role);
        try {
            return ResponseEntity.ok(companyService.getEmployerByRole(role));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
