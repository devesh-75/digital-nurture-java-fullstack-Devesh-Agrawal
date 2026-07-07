package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        try {
            testGetAllCountries();
            testFindCountryByCode();
            testAddCountry();
            testUpdateCountry();
            testFindCountriesByPartialName();
            testDeleteCountry();
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found", e);
        }
    }

    // Hands on 1
    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries={}", countries.size());
        LOGGER.info("End");
    }

    // Hands on 6
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country={}", country);
        LOGGER.info("End");
    }

    // Hands on 7
    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country newCountry = new Country("XX", "Testland");
        countryService.addCountry(newCountry);

        Country added = countryService.findCountryByCode("XX");
        LOGGER.debug("Added country={}", added);
        LOGGER.info("End");
    }

    // Hands on 8
    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start");
        countryService.updateCountry("XX", "Testland Updated");

        Country updated = countryService.findCountryByCode("XX");
        LOGGER.debug("Updated country={}", updated);
        LOGGER.info("End");
    }

    // Hands on 5
    private static void testFindCountriesByPartialName() {
        LOGGER.info("Start");
        List<Country> matches = countryService.findCountriesByPartialName("stan");
        LOGGER.debug("Countries matching 'stan'={}", matches);
        LOGGER.info("End");
    }

    // Hands on 9
    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("XX");
        LOGGER.info("Deleted country with code XX");
        LOGGER.info("End");
    }
}
