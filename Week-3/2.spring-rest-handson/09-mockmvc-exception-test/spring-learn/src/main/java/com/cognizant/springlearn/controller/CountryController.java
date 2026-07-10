package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    @Qualifier("in")
    private Country india;

    @Autowired
    @Qualifier("countryList")
    private List<Country> countryList;

    @Autowired
    private CountryService countryService;

    public CountryController() {
        LOGGER.info("CountryController Constructor - START");
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("getCountryIndia() - START");
        Country response = india;
        LOGGER.info("getCountryIndia() - END");
        return response;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("getAllCountries() - START");
        List<Country> response = countryList;
        LOGGER.info("getAllCountries() - END");
        return response;
    }

    @GetMapping({"/countries/{code}", "/country/{code}"})
    public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
        LOGGER.info("getCountry() - START for code: " + code);
        Country response = countryService.getCountry(code);
        LOGGER.info("getCountry() - END");
        return response;
    }
}
