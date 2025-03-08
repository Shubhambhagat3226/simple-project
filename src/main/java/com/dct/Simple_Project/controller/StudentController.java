package com.dct.Simple_Project.controller;

import com.dct.Simple_Project.entity.Students;
import com.dct.Simple_Project.error.InvalidAgeException;
import com.dct.Simple_Project.error.InvalidNameException;
import com.dct.Simple_Project.error.StudentNotFound;
import com.dct.Simple_Project.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping("/students")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public List<Students> fetchAllStudent() {
        return service.fetchAllStudent();
    }

    // CREATE DATA
    @PostMapping("/student")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public Students createStudentData(@RequestBody Students student) throws InvalidAgeException, InvalidNameException {
        return service.createStudentData(student);
    }

    // GET BY ID
    @GetMapping("/student/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public Students fetchStudentById(@PathVariable("id") int id) throws StudentNotFound {
        return service.fetchStudentById(id);
    }

    // UPDATE BY ID
    @PutMapping("/student/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public Students updateStudentDataById(@PathVariable("id") int id,
                                          @RequestBody Students newStudentData) throws StudentNotFound {
        return service.updateStudentDataById(id, newStudentData);
    }

    // DELETE BY ID
    @DeleteMapping("/student/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public String deleteStudentDataById(@PathVariable("id") int id) throws StudentNotFound {
        service.deleteStudentById(id);
        return "Successfully deleted!";

    }
}
