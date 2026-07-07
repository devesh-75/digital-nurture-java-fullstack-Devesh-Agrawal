package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException(countryCode);
        }

        return result.get();
    }

    // Hands on 1: search by partial name (search text box)
    @Transactional
    public List<Country> searchByName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }

    // Hands on 1: same search, sorted ascending by name
    @Transactional
    public List<Country> searchByNameSortedAscending(String partialName) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(partialName);
    }

    // Hands on 1: alphabet index - countries starting with a given letter
    @Transactional
    public List<Country> findByStartingLetter(String letter) {
        return countryRepository.findByNameStartingWithIgnoreCase(letter);
    }
}
