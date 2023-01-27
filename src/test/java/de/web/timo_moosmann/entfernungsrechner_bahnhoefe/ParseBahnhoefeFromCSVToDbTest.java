package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import de.web.timo_moosmann.entfernungsrechner_bahnhoefe.bahnhoflocationutils.BahnhofLocation;
import de.web.timo_moosmann.entfernungsrechner_bahnhoefe.bahnhoflocationutils.BahnhofLocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ParseBahnhoefeFromCSVToDbTest {

    @Autowired
    private BahnhofLocationRepository bahnhofLocationRepository;

    @Test
    public void testHanauHbfWasCorrectlyParsedAndCanBeFetchedByDS100() {
        BahnhofLocation expectedBahnhofLocationHanauHBF = new BahnhofLocation(
                Arrays.asList("FH", "FH  N", "FH  S"),
                "Hanau Hbf",
                50.120953,
                8.929
        );

        BahnhofLocation bahnhofLocationHanauHbfFetch1 = bahnhofLocationRepository.retrieveByDS100("FH");
        BahnhofLocation bahnhofLocationHanauHbfFetch2 = bahnhofLocationRepository.retrieveByDS100("FH  N");
        BahnhofLocation bahnhofLocationHanauHbfFetch3 = bahnhofLocationRepository.retrieveByDS100("FH  S");

        assertEquals(expectedBahnhofLocationHanauHBF, bahnhofLocationHanauHbfFetch1);
        assertEquals(expectedBahnhofLocationHanauHBF, bahnhofLocationHanauHbfFetch2);
        assertEquals(expectedBahnhofLocationHanauHBF, bahnhofLocationHanauHbfFetch3);
    }

    @Test
    public void testJenaGoeschwitzWasCorrectlyParsedAndCanBeFetchedByDS100() {
        BahnhofLocation expectedBahnhofLocationJenaGoeschwitz = new BahnhofLocation(
                Collections.singletonList("UGW"),
                "Jena-Göschwitz",
                50.883942,
                11.593537
        );
        BahnhofLocation bahnhofLocationJenaGoeschwitzFetch = bahnhofLocationRepository.retrieveByDS100("UGW");
        assertEquals(expectedBahnhofLocationJenaGoeschwitz, bahnhofLocationJenaGoeschwitzFetch);
    }

    @Test
    public void testUeberseeWasCorrectlyParsedAndCanBeFetchedByDS100() {
        BahnhofLocation expectedBahnhofLocationUebersee = new BahnhofLocation(
                Collections.singletonList("MUS"),
                "Übersee",
                47.822047,
                12.487338
        );
        BahnhofLocation bahnhofLocationUeberseeFetch = bahnhofLocationRepository.retrieveByDS100("MUS");
        assertEquals(expectedBahnhofLocationUebersee, bahnhofLocationUeberseeFetch);
    }

    @Test
    public void testATotalOf357BahnhoefeParsedIntoDB() {
        assertEquals(357, bahnhofLocationRepository.count());
    }
}
