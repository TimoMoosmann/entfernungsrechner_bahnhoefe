package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import com.opencsv.CSVReaderHeaderAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
public class LoadBahnhofLocationTable {

    private static final Logger log = LoggerFactory.getLogger(LoadBahnhofLocationTable.class);

    @Autowired
    private CsvParserService csvParserService;

    @Autowired
    private StringParser numberFormatter;

    @Bean
    CommandLineRunner initDatabase(BahnhofLocationRepository bahnhofLocationRepository) {

        return args -> {
            String bahnhoefeCsvPath = ClassLoader.getSystemResource("csv/D_Bahnhof_2020_alle.csv").getPath();

            CSVReaderHeaderAware csvReaderHeaderAware =
                    csvParserService.getCSVReaderHeaderAware(bahnhoefeCsvPath, ';');

            Map<String, String> currentLine = csvReaderHeaderAware.readMap();
            List<BahnhofLocation> fernverkehrBahnhofLocations = new ArrayList<>();

            while (currentLine != null) {
                if ((currentLine.get("Verkehr")).equals("FV")) {
                    fernverkehrBahnhofLocations.add(new BahnhofLocation(
                            Arrays.asList(currentLine.get("DS100").split(",")),
                            currentLine.get("NAME"),
                            numberFormatter.getDoubleFromGermanNumberString(currentLine.get("Breite")),
                            numberFormatter.getDoubleFromGermanNumberString(currentLine.get("Laenge"))
                    ));
                }
                currentLine = csvReaderHeaderAware.readMap();
            }
            log.info("Inserted {} BahnhofLocation Objects into Database.", fernverkehrBahnhofLocations.size());
            bahnhofLocationRepository.saveAll(fernverkehrBahnhofLocations);
        };
    }
}
