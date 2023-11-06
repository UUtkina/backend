package ait.de.repositories;

import ait.de.model.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("studentsRepositoryList")
public class StudentsRepositoryListImpl {
private final List<Student> students=new ArrayList<>();

private Long generatorId=1L;

public Student findById(Long id){return null;}

    public List<Student> findAll(){return new ArrayList<>(students);}

    public void saveStudent(Student student){
    students.add(student);
    student.setId(generatorId);
    generatorId++;
    }

    public  void deleteById(Long id){

    }

    public void update(Student model){

    }
    public StudentsRepositoryListImpl() {

        saveStudent(new Student(1l,"Halina","Utkina",20,"IT","cohort 28"));
        saveStudent(new Student(2l,"Nick","Smirnov",21,"IT","cohort 27"));
    }

}
