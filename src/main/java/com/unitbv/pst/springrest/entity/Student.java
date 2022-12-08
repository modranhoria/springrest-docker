package com.unitbv.pst.springrest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@SequenceGenerator(name = "student_seq", initialValue = 3, allocationSize = 100)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_fulltime")
    private Boolean fulltime;

    @Column(name = "student_age")
    private Integer age;

    @ManyToMany
    @JoinTable(name="enrollment",
            joinColumns = {@JoinColumn(name="student_id")},
            inverseJoinColumns = {@JoinColumn(name="course_id")} )
    private List<Course> courseList = new ArrayList<>();

    public Student(){
    }

    public Student(Integer id, String name, boolean fulltime, Integer age, List<Course> courseList) {
        this.id = id;
        this.name = name;
        this.fulltime = fulltime;
        this.age = age;
        this.courseList = courseList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isFulltime() {
        return fulltime;
    }

    public void setFulltime(Boolean fulltime) {
        this.fulltime = fulltime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
