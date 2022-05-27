package com.example.departmentrestapi.departmentRestApi.repository;

import com.example.departmentrestapi.departmentRestApi.controller.DepartmentController;
import com.example.departmentrestapi.departmentRestApi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByName(String name);

    Department findByNameIgnoreCase(String name);
}
