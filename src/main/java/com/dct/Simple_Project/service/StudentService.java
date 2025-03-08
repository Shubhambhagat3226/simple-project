package com.dct.Simple_Project.service;

import com.dct.Simple_Project.entity.Students;
import com.dct.Simple_Project.error.InvalidAgeException;
import com.dct.Simple_Project.error.InvalidNameException;
import com.dct.Simple_Project.error.StudentNotFound;

import java.util.List;

public interface StudentService {
    List<Students> fetchAllStudent();

    Students createStudentData(Students student) throws InvalidAgeException, InvalidNameException;

    Students fetchStudentById(int id) throws StudentNotFound;

    Students updateStudentDataById(int id, Students newStudentData) throws StudentNotFound;

    void deleteStudentById(int id) throws StudentNotFound;
}
