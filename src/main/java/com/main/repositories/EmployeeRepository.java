package com.main.repositories;

import com.main.dtos.RequestDTO;
import com.main.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT max(id) FROM employee", nativeQuery = true)
    long findMaxid();
}
