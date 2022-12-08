package com.unitbv.pst.springrest.controller;

import com.unitbv.pst.springrest.entity.Department;
import com.unitbv.pst.springrest.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentService.getDepartment(id);
    }

    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id") Integer id){
        departmentService.deleteDepartment(id);
    }

}