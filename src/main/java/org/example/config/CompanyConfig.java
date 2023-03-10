package org.example.config;

import org.example.company.ITCompany;
import org.example.company.employee.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example.company")
public class CompanyConfig {
    @Bean
    @Primary
    public ITCompany getITCompany(Employee<ITRole> director) {
        ITCompany company = new ITCompany("SomePrimaryCompany");
        company.setDirector(director);
        return company;
    }

    @Bean
    public ITCompany getAnotherITCompany() {
        return new ITCompany("AnotherCompany");
    }

    @Bean
    public Employee<ITRole> getDirector() {
        return new Employee<>("Oleg", 30, ITRole.Director) {
            @Override
            public void work() {
                System.out.println(this.getName() + "is directing");
            }
        };
    }

    @Bean("CompanyName")
    public String getCompanyName(){
        return "SomeFirstCompany";
    }

    @Bean("MaxEmployerCount")
    public int getCount() {
        return 100;
    }
}
