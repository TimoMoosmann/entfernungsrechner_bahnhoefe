package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.springframework.stereotype.Service;

@Service
public class GeoLocationDistanceService {

    Double getHaversineDistance(
            double latitude1, double longitude1,
            double latitude2, double longitude2,
            double radius
    ) {
        double latitudeDiffRadians = Math.toRadians(latitude2 - latitude1);
        double longitudeDiffRadians = Math.toRadians(longitude2 - longitude1);
        double latitude1Radians = Math.toRadians(latitude1);
        double latitude2Radians = Math.toRadians(latitude2);

        double inner = Math.pow(Math.sin(latitudeDiffRadians / 2), 2) +
                Math.cos(latitude1Radians) * Math.cos(latitude2Radians) *
                        Math.pow(Math.sin(longitudeDiffRadians / 2), 2);
        return 2 * radius * Math.asin(Math.sqrt(inner));
    }
}
