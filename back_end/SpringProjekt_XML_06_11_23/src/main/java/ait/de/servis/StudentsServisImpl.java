package ait.de.servis;

import ait.de.repositories.StudentsRepositoryListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentsServisImpl {
    private final StudentsRepositoryListImpl studentsRepository;

    @Autowired
    public StudentsServisImpl(
            @Qualifier("studentsRepositoryList") StudentsRepositoryListImpl studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
}