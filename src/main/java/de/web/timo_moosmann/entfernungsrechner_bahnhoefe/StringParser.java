package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.springframework.stereotype.Service;

@Service
public class StringParser {

    public Double getDoubleFromGermanNumberString(String germanNumberString) {
        return Double.parseDouble(germanNumberString.replace(',', '.'));
    }
}