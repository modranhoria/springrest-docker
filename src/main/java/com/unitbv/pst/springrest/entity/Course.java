package com.unitbv.pst.springrest.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "course")
@SequenceGenerator(name = "course_seq", initialValue = 3, allocationSize = 100)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name")
    private String name;

    @ManyToOne
    @JoinColumn(name="course_dept_id", referencedColumnName = "dept_id")
    private Department department;

    public Course(){
    }

    public Course(Integer id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
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

    @JsonBackReference
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
