package com.cognizant.ormlearn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dp_id")
    private int id;

    @Column(name = "dp_name")
    private String name;

    // inverse side of the Employee.department @ManyToOne relationship.
    // Default fetch for @OneToMany is LAZY, which throws
    // LazyInitializationException once the Session is closed (e.g. after
    // Department.get() returns from a @Transactional service method) if the
    // list is accessed later. Setting EAGER here loads the employees in the
    // same query so the list is usable after the transaction ends.
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Employee> employeeList;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        // employeeList intentionally left out to avoid Employee <-> Department
        // toString() recursion (Employee.toString() prints the department name).
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
