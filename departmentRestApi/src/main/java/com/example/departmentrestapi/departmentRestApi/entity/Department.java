package com.example.departmentrestapi.departmentRestApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=2, message ="Field name should have at least 2 characters")
    private String name;

    @NotNull
    @Size(min=2, message ="Field address should have at least 2 characters")
    private String address;

    @NotNull
    @Size(min=2, message ="Field code should have at least 2 characters")
    private String code;


}
