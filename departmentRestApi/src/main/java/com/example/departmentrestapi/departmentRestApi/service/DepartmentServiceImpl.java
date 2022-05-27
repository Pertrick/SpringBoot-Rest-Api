package com.example.departmentrestapi.departmentRestApi.service;

import com.example.departmentrestapi.departmentRestApi.entity.Department;
import com.example.departmentrestapi.departmentRestApi.exception.DepartmentNotFoundException;
import com.example.departmentrestapi.departmentRestApi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
       Optional<Department> department = departmentRepository.findById(id);

       if(!department.isPresent()){
           throw new DepartmentNotFoundException("Department Not Found!");
       }

       return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Department department, Long id) throws DepartmentNotFoundException {
        Department getDepartment = getDepartmentById(id);

        if(!"".equalsIgnoreCase(getDepartment.getName()) && Objects.nonNull(getDepartment.getName())){
            getDepartment.setName(department.getName());
        }

        if(!"".equalsIgnoreCase(getDepartment.getAddress()) && Objects.nonNull(getDepartment.getAddress())){
            getDepartment.setAddress(department.getAddress());
        }


        if(!"".equalsIgnoreCase(getDepartment.getCode()) && Objects.nonNull(getDepartment.getCode())){
            getDepartment.setCode(department.getCode());
        }

        return departmentRepository.save(getDepartment);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
    }
}
