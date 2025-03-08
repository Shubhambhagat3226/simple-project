package com.dct.Simple_Project.service;

import com.dct.Simple_Project.entity.Students;
import com.dct.Simple_Project.error.InvalidAgeException;
import com.dct.Simple_Project.error.InvalidNameException;
import com.dct.Simple_Project.error.StudentNotFound;
import com.dct.Simple_Project.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Students> fetchAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Students createStudentData(Students student) throws InvalidAgeException, InvalidNameException {

        if (student.getName() == null || student.getName().isBlank()) {
            throw new InvalidNameException("Name Should not be empty");
        }

        if (student.getAge() < 18) {
            throw new InvalidAgeException("Age can not be less then 18");
        }

        return studentRepo.save(student);
    }

    @Override
    public Students fetchStudentById(int id) throws StudentNotFound {
        Optional<Students> student = studentRepo.findById(id);

        if (student.isPresent()) return student.get();
        else throw new StudentNotFound("Student Not Found");
    }

    @Override
    public Students updateStudentDataById(int id, Students newStudentData) throws StudentNotFound {
        Students student = fetchStudentById(id);

        if (!newStudentData.getName().isBlank() && newStudentData.getName() != null &&
                !"".equalsIgnoreCase(newStudentData.getName())) {
            student.setName(newStudentData.getName());
        }
        if (newStudentData.getAge() >= 18) {
            student.setAge(newStudentData.getAge());
        }
        if (newStudentData.getDept() != null && !"".equalsIgnoreCase(newStudentData.getName())) {
            student.setDept(newStudentData.getDept());
        }

        return studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(int id) throws StudentNotFound {
        Students student = fetchStudentById(id);
        studentRepo.delete(student);
    }
}
