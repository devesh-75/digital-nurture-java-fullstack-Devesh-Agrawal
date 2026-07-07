package com.example.ems.repository;

import com.example.ems.model.Employee;
import com.example.ems.projection.EmployeeDto;
import com.example.ems.projection.EmployeeSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Ex 3 & 6: Derived Query Method with Pagination/Sorting
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Ex 5: Custom Query using @Query Annotation
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmailCustom(@Param("email") String email);

    // Ex 5: Executing Named Query defined in Employee entity class
    // Spring Data automatically resolves "Employee.findByEmail" because the method matches the name query's naming pattern.
    // Or we can declare it directly.
    Employee findByEmail(String email);

    // Ex 8: Interface-Based Projection
    List<EmployeeSummary> findByDepartmentName(String departmentName);

    // Ex 8: Class-Based Projection (using Constructor Expression in @Query)
    @Query("SELECT new com.example.ems.projection.EmployeeDto(e.name, e.email, e.department.name) " +
           "FROM Employee e WHERE e.id = :id")
    EmployeeDto findEmployeeDtoById(@Param("id") Long id);
}
