package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class LoadBahnhofLocationTable {

    private static final Logger log = LoggerFactory.getLogger(LoadBahnhofLocationTable.class);

    @Bean
    CommandLineRunner initDatabase(BahnhofLocationRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new BahnhofLocation(
                    Arrays.asList("FH","FH  N","FH  S"),
                    "Hanau Hbf",
                    8.929,
                    50.120953
            )));
            log.info("Preloading " + repository.save(new BahnhofLocation(
                    Collections.singletonList("HH"),
                    "Hannover Hbf",
                    9.741021,
                    52.376761
            )));

            log.info("Load id 1: " + repository.findById((long)1));
            log.info("From DS100 = FH, got: " + repository.retrieveByDS100("FH"));
        };
    }
}
