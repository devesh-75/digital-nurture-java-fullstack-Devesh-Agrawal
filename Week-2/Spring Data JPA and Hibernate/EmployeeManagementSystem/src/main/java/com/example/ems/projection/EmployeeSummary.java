package com.example.ems.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeSummary {
    String getName();
    String getEmail();

    // Ex 8: Dynamic Projection using SpEL (@Value)
    @Value("#{target.name + ' <' + target.email + '>'}")
    String getFullContactInfo();
}
