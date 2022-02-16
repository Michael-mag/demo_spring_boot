package com.michael.magaisa.student_application.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudents(@RequestBody Student student){
        studentService.registerNewStudents(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudents(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable(value = "studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
            ){
        studentService.updateStudent(studentId, name, email);
    }
}
