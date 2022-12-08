package com.unitbv.pst.springrest.service;

import com.unitbv.pst.springrest.entity.Course;
import com.unitbv.pst.springrest.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourse(Integer id){
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourseById(Integer id){
        courseRepository.deleteById(id);
    }
}
