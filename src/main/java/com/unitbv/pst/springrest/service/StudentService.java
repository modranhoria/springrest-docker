package com.unitbv.pst.springrest.service;

import com.unitbv.pst.springrest.entity.Student;
import com.unitbv.pst.springrest.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent (Integer id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public Student updatePatchStudent (Integer id, Student student) {
        Student modifiedStudent = studentRepository.findById(id).get();
        student.setId(id);
        if(student.getName() != null){
            modifiedStudent.setName(student.getName());
        }
        if(student.isFulltime() != null){
            modifiedStudent.setFulltime(student.isFulltime());
        }
        if(student.getAge() != null){
            modifiedStudent.setAge(student.getAge());
        }
        return studentRepository.save(modifiedStudent);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
