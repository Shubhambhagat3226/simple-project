package com.dct.Simple_Project.controller;

import com.dct.Simple_Project.entity.Students;
import com.dct.Simple_Project.error.InvalidAgeException;
import com.dct.Simple_Project.error.InvalidNameException;
import com.dct.Simple_Project.error.StudentNotFound;
import com.dct.Simple_Project.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://shubhambhagat3226.github.io")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping("/students")
    public List<Students> fetchAllStudent() {
        return service.fetchAllStudent();
    }

    // CREATE DATA
    @PostMapping("/student")
    public Students createStudentData(@RequestBody Students student) throws InvalidAgeException, InvalidNameException {
        return service.createStudentData(student);
    }

    // GET BY ID
    @GetMapping("/student/{id}")
    public Students fetchStudentById(@PathVariable("id") int id) throws StudentNotFound {
        return service.fetchStudentById(id);
    }

    // UPDATE BY ID
    @PutMapping("/student/{id}")
    public Students updateStudentDataById(@PathVariable("id") int id,
                                          @RequestBody Students newStudentData) throws StudentNotFound {
        return service.updateStudentDataById(id, newStudentData);
    }

    // DELETE BY ID
    @DeleteMapping("/student/{id}")
    public String deleteStudentDataById(@PathVariable("id") int id) throws StudentNotFound {
        service.deleteStudentById(id);
        return "Successfully deleted!";

    }
}
