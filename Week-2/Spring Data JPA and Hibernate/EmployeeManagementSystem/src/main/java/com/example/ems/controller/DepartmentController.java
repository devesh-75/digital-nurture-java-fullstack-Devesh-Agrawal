package com.example.ems.controller;

import com.example.ems.model.Department;
import com.example.ems.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Ex 4: Read All
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Ex 4: Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ex 4: Create
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department saved = departmentRepository.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Ex 4: Update
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department deptDetails) {
        return departmentRepository.findById(id)
                .map(dept -> {
                    dept.setName(deptDetails.getName());
                    return ResponseEntity.ok(departmentRepository.save(dept));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Ex 4: Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Ex 5: Custom lookup using Derived query matching Named Query
    @GetMapping("/search")
    public ResponseEntity<Department> getDepartmentByName(@RequestParam String name) {
        Department dept = departmentRepository.findByName(name);
        return dept != null ? ResponseEntity.ok(dept) : ResponseEntity.notFound().build();
    }
}
