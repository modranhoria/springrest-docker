package com.unitbv.pst.springrest.controller;

import com.unitbv.pst.springrest.entity.Student;
import com.unitbv.pst.springrest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Integer id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }


    @PutMapping("/{id}")
    public Student updateStudent (@PathVariable("id") Integer id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @PatchMapping("/{id}")
    public Student updatePatchStudent (@PathVariable("id") Integer id, @RequestBody Student student){
        return studentService.updatePatchStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
    }

}

