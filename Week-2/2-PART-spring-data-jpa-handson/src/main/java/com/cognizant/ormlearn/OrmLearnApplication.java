package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        // ---- Hands on 1: Query Methods on country table ----
        testSearchCountry();
        testSearchCountrySortedAscending();
        testCountriesStartingWithLetter();

        // ---- Hands on 2: Query Methods on stock table ----
        testFacebookSeptember2019();
        testGoogleAboveThreshold();
        testTopVolumeDates();
        testNetflixLowestClose();

        // ---- Hands on 4: many-to-one (Employee -> Department) ----
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();

        // ---- Hands on 5: one-to-many (Department -> Employees) ----
        testGetDepartment();

        // ---- Hands on 6: many-to-many (Employee <-> Skill) ----
        testAddSkillToEmployee();
    }

    private static void testSearchCountry() {
        LOGGER.info("Start");
        List<Country> countries = countryService.searchByName("ou");
        countries.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End");
    }

    private static void testSearchCountrySortedAscending() {
        LOGGER.info("Start");
        List<Country> countries = countryService.searchByNameSortedAscending("ou");
        countries.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End");
    }

    private static void testCountriesStartingWithLetter() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findByStartingLetter("Z");
        countries.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End");
    }

    private static void testFacebookSeptember2019() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetweenOrderByDateAsc(
                "FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testGoogleAboveThreshold() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testTopVolumeDates() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testNetflixLowestClose() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    // Hands on 4 / 5 / 6: employee with department (eager @ManyToOne) and
    // skills (eager @ManyToMany) all loaded together
    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.debug("Skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee("Sarah Connor", 58000, true, new Date());
        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Employee after save:{}", employee);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(3);
        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Employee after update:{}", employee);
        LOGGER.info("End");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start");
        // department id 1 (Engineering) has more than one employee
        Department department = departmentService.get(1);
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees:{}", department.getEmployeeList());
        LOGGER.info("End");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");
        // employee id 4 (Emma Davis) and skill id 4 (Leadership) do not have
        // an existing relationship yet
        Employee employee = employeeService.get(4);
        Skill skill = skillService.get(4);

        Set<Skill> skills = employee.getSkillList();
        if (skills == null) {
            skills = new HashSet<>();
        }
        skills.add(skill);
        employee.setSkillList(skills);

        employeeService.save(employee);
        LOGGER.debug("Employee after adding skill:{}", employee);
        LOGGER.info("End");
    }
}
