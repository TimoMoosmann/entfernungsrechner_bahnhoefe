package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/distance")
public class BahnhofEntfernungsrechnerController {

    @GetMapping("/{startDS100}/{destinationDS100}")
    public BahnhoefeDistance getDistance(@PathVariable String startDS100, @PathVariable String destinationDS100) {
        return new BahnhoefeDistance(
                "Frankfurt(Main)Hbf",
                "Berlin Hbf",
                423
        );
    }
}
