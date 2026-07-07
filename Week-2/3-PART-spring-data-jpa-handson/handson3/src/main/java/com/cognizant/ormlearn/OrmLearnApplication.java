package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.service.AttemptService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        attemptService = context.getBean(AttemptService.class);

        testGetAttemptDetail();
    }

    public static void testGetAttemptDetail() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1);
        if (attempt != null) {
            System.out.println("\n--- QUIZ ATTEMPT DETAIL ---");
            attempt.getAttemptQuestions().forEach(aq -> {
                System.out.println(aq.getQuestion().getText());
                List<AttemptOption> aos = aq.getAttemptOptions();
                for (int i = 0; i < aos.size(); i++) {
                    AttemptOption ao = aos.get(i);
                    System.out.printf(" %d) %-12s %-7.1f %s%n",
                            (i + 1),
                            ao.getOptions().getText(),
                            ao.getOptions().getScore(),
                            ao.isSelected());
                }
                System.out.println();
            });
            System.out.println("---------------------------\n");
        } else {
            System.out.println("Attempt not found!");
        }
        LOGGER.info("End");
    }
}
