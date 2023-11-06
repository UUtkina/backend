package ait;

import ait.de.config.StudentConfig;
import ait.de.repositories.StudentsRepositoryListImpl;
import ait.de.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentsRepositoryListImpl studentsRepository = context.getBean(StudentsRepositoryListImpl.class);
        List<Student> students = studentsRepository.findAll();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

