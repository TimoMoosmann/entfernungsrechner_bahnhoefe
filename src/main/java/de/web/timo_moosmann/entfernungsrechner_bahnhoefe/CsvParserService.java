package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class CsvParserService {
    public CSVReaderHeaderAware getCSVReaderHeaderAware(String csvPath, char separator) throws FileNotFoundException {
        return (CSVReaderHeaderAware) new CSVReaderHeaderAwareBuilder(new FileReader(csvPath)).withCSVParser(
                new CSVParserBuilder().withSeparator(separator).build()
        ).build();
    }
}
