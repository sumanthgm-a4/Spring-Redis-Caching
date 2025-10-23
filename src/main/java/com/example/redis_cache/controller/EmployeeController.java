package com.example.redis_cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.redis_cache.model.Employee;
import com.example.redis_cache.repository.EmployeeRepo;

@RepositoryRestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;

    @GetMapping(value="/employees")
    @Cacheable(value="employees", key="'all'")
    @ResponseBody
    public List<Employee> findAll() {
        return repo.findAll();
    }

}
