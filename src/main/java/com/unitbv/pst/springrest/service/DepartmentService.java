package com.unitbv.pst.springrest.service;

import com.unitbv.pst.springrest.entity.Department;
import com.unitbv.pst.springrest.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }
}
