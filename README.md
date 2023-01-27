# Case Study: Entfernungsrechner Bahnhöfe

Projekt für den Auswahltag des Sprintstarterprogramms der DB Systel.

## Aufgabe

Implementierung eines Entfernungsrechners zwischen Bahnhöfen in Form einer REST Schnittstelle.

### Beispiel

Anfrage: GET /api/v1/distance/FF/BLS

Antwort: {
  "from": "Frankfurt(Main)Hbf",
  "to": "Berlin Hbf",
  "distance": 423,
  "unit": "km"
}

## Technologie Wahl

Spring Boot 3 mit Java 17

## Benutzung

Für die Benutung werden Java 17 und Maven benötigt.

In dem root Ordner des Projekts, führe folgende Befehle aus:

```console
./mvnw clean spring-boot:run
```
Um den Webserver zu starten.

```console
./mvnw test
```
Um Unit und Integration Tests auszuführen.
