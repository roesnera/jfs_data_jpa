package com.example.jfs_data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getAll(){
        return studentService.getStudents();
    }

    @PostMapping
    public @ResponseBody String addOne(@RequestParam String name){

        Student s = new Student();
        s.setName(name);
        studentService.addStudent(s);
        return "Added";
    }
}
