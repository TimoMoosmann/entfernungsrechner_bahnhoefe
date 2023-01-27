package de.web.timo_moosmann.entfernungsrechner_bahnhoefe.distancecalculator;

public record BahnhoefeDistance(String from, String to, int distance, String unit) {
    public BahnhoefeDistance(String from, String to, int distance) {
        this(from, to, distance, "km");
    }
}
