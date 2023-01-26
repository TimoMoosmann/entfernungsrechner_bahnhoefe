package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/distance")
public class BahnhofEntfernungsrechnerController {

    @Autowired
    BahnhofLocationRepository bahnhofLocationRepository;

    @Autowired
    GeoLocationDistanceService geoLocationDistanceService;

    @GetMapping("/{startDS100}/{destinationDS100}")
    public BahnhoefeDistance getDistance(@PathVariable String startDS100, @PathVariable String destinationDS100) {
        BahnhofLocation bahnhofLocationStart = bahnhofLocationRepository.retrieveByDS100(startDS100);
        if (bahnhofLocationStart == null) {
            throw new BahnhofNotFoundException(startDS100);
        }
        BahnhofLocation bahnhofLocationDestination = bahnhofLocationRepository.retrieveByDS100(destinationDS100);
        if (bahnhofLocationDestination == null) {
            throw new BahnhofNotFoundException(destinationDS100);
        }
        return new BahnhoefeDistance(
                bahnhofLocationStart.getFullName(),
                bahnhofLocationDestination.getFullName(),
                geoLocationDistanceService.getApproximatedDistance(
                        bahnhofLocationStart.getLatitude(), bahnhofLocationStart.getLongitude(),
                        bahnhofLocationDestination.getLatitude(), bahnhofLocationDestination.getLongitude()
                )
        );
    }
}
