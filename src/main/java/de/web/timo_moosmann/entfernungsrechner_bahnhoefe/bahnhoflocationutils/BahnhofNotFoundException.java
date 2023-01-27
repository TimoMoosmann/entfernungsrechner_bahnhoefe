package de.web.timo_moosmann.entfernungsrechner_bahnhoefe.bahnhoflocationutils;

public class BahnhofNotFoundException extends RuntimeException {
    public BahnhofNotFoundException(String ds100) {
        super("Could not find Bahnhof with DS100 Code: " + ds100);
    }
}
