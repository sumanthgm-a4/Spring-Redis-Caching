package com.example.redis_cache.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redis_cache.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    
    @Cacheable(value="employee", key="#id")
    Optional<Employee> findById(Integer id);

    @Cacheable(value="allEmployees", key="'all'")
    List<Employee> findAll();

    @CachePut(value="employee", key="#result.id")
    Employee save(Employee employee);

    @CacheEvict(value="employee", key="#id")
    void deleteById(Integer id);
}
