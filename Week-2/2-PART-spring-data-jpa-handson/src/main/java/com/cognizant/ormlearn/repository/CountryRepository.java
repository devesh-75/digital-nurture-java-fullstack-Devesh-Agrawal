package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // search text box: all countries whose name contains the given text
    List<Country> findByNameContainingIgnoreCase(String partialName);

    // same search, but results sorted by name ascending
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String partialName);

    // alphabet index: all countries whose name starts with the given letter
    List<Country> findByNameStartingWithIgnoreCase(String letter);
}
