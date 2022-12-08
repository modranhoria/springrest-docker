package com.unitbv.pst.springrest.controller;

import com.unitbv.pst.springrest.entity.Course;
import com.unitbv.pst.springrest.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Integer id){
        return courseService.getCourse(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }


    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Integer id){
        courseService.deleteCourseById(id);
    }
}
