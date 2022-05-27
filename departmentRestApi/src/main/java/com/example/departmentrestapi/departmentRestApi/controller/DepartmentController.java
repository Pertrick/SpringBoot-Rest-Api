package com.example.departmentrestapi.departmentRestApi.controller;

import com.example.departmentrestapi.departmentRestApi.entity.Department;
import com.example.departmentrestapi.departmentRestApi.exception.DepartmentNotFoundException;
import com.example.departmentrestapi.departmentRestApi.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(Department.class);


    @PostMapping("")
    public Department saveDepartment(@Valid @RequestBody Department department){
        //LOGGER.info("Inside SaveDepartment Controller" + department);
        return departmentService.save(department);
    }

    @GetMapping("")
    public List<Department> getDepartments(){
       // LOGGER.info("inside getDepartment "+ departmentService.getDepartments());
        return  departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);

    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return "Department Deleted Successfully!";

    }

    @PutMapping("/{id}")
    public Department updateDepartmentById(@Valid @PathVariable("id")  Long id, @RequestBody Department department) throws DepartmentNotFoundException {

       return departmentService.updateDepartmentById(department,id);
    }

    @GetMapping("name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        return departmentService.getDepartmentByName(name);
    }


}
