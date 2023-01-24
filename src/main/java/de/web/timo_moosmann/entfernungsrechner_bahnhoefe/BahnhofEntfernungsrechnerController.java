package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BahnhofEntfernungsrechnerController {

    @GetMapping("/distance/FF/BLS")
    public BahnhoefeDistance helloWorld() {
        return new BahnhoefeDistance("a", "b", 23, "km");
    }
}
