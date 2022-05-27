package com.example.departmentrestapi.departmentRestApi.service;

import com.example.departmentrestapi.departmentRestApi.entity.Department;
import com.example.departmentrestapi.departmentRestApi.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    List<Department> getDepartments();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartmentById(Department department, Long id) throws DepartmentNotFoundException;

    Department getDepartmentByName(String name);
}
