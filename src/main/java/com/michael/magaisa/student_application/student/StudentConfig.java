package com.michael.magaisa.student_application.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student michael = new Student(
                    "Michael",
                    "michael@mail.com",
                    LocalDate.of(2000, Month.MARCH, 15),
                    LocalDate.now().getYear() - LocalDate.of(2000, Month.MARCH, 15).getYear()
            );

            Student magaisa = new Student(
                    "magaisa",
                    "mag@mail.com",
                    LocalDate.of(2000, Month.MARCH, 15),
                    LocalDate.now().getYear() - LocalDate.of(2000, Month.MARCH, 15).getYear()
            );

            repository.saveAll(
                    List.of(michael, magaisa)
            );
        };
    }
}
