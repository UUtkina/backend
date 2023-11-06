package ait.de.config;

import ait.de.repositories.StudentsRepositoryListImpl;
import ait.de.servis.StudentsServisImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ait.de")
public class StudentConfig {
    @Bean
    public StudentsRepositoryListImpl studentsRepositoryList() {
        return new StudentsRepositoryListImpl();
    }

    @Bean
    public StudentsServisImpl studentsServis(@Qualifier("studentsRepositoryList") StudentsRepositoryListImpl studentsRepository) {
        return new StudentsServisImpl(studentsRepository);
    }
}
