package com.example.ems.service;

import com.example.ems.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EmployeeBatchService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Ex 10: Batch Processing with Hibernate.
     * Periodically flushes and clears the Hibernate Session (Persistence Context)
     * to manage memory efficiently during bulk operations.
     */
    @Transactional
    public void saveInBatch(List<Employee> employees) {
        int batchSize = 30; // Matches config in application.properties
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }
}
