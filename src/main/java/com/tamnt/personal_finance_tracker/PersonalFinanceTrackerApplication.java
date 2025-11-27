package com.tamnt.personal_finance_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PersonalFinanceTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalFinanceTrackerApplication.class, args);
    }

}
