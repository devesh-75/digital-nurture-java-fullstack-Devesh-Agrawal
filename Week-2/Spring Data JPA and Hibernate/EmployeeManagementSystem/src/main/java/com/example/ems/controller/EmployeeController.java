package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.projection.EmployeeDto;
import com.example.ems.projection.EmployeeSummary;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeBatchService employeeBatchService;

    // Ex 4: Read All
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Ex 4: Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ex 4: Create
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee saved = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Ex 4: Update
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee empDetails) {
        return employeeRepository.findById(id)
                .map(emp -> {
                    emp.setName(empDetails.getName());
                    emp.setEmail(empDetails.getEmail());
                    emp.setDepartment(empDetails.getDepartment());
                    return ResponseEntity.ok(employeeRepository.save(emp));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Ex 4: Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Ex 6: Search with Pagination and Sorting
    @GetMapping("/search")
    public Page<Employee> searchEmployees(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    // Ex 5: Custom Query (@Query) Lookup
    @GetMapping("/email-custom")
    public ResponseEntity<Employee> getByEmailCustom(@RequestParam String email) {
        Employee employee = employeeRepository.findByEmailCustom(email);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    // Ex 5: Named Query Lookup
    @GetMapping("/email-named")
    public ResponseEntity<Employee> getByEmailNamed(@RequestParam String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    // Ex 8: Interface-Based Projection
    @GetMapping("/projection/summary")
    public List<EmployeeSummary> getSummariesByDept(@RequestParam String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }

    // Ex 8: Class-Based DTO Projection
    @GetMapping("/projection/dto/{id}")
    public ResponseEntity<EmployeeDto> getDtoById(@PathVariable Long id) {
        EmployeeDto dto = employeeRepository.findEmployeeDtoById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // Ex 10: Batch Insert Bulk Employees
    @PostMapping("/batch")
    public ResponseEntity<String> createEmployeesInBatch(@RequestBody List<Employee> employees) {
        employeeBatchService.saveInBatch(employees);
        return ResponseEntity.ok("Successfully inserted " + employees.size() + " employees in batches.");
    }
}
