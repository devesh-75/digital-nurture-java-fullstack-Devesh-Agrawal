package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    @Qualifier("in")
    private Country india;

    @Autowired
    @Qualifier("countryList")
    private List<Country> countryList;

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        return india;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryList;
    }
}
