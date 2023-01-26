package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

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
                8.929,
                50.120953
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
                11.593537,
                50.883942
        );
        BahnhofLocation bahnhofLocationJenaGoeschwitzFetch = bahnhofLocationRepository.retrieveByDS100("UGW");
        assertEquals(expectedBahnhofLocationJenaGoeschwitz, bahnhofLocationJenaGoeschwitzFetch);
    }

    @Test
    public void testUeberseeWasCorrectlyParsedAndCanBeFetchedByDS100() {
        BahnhofLocation expectedBahnhofLocationUebersee = new BahnhofLocation(
                Collections.singletonList("MUS"),
                "Übersee",
                12.487338,
                47.822047
        );
        BahnhofLocation bahnhofLocationUeberseeFetch = bahnhofLocationRepository.retrieveByDS100("MUS");
        assertEquals(expectedBahnhofLocationUebersee, bahnhofLocationUeberseeFetch);
    }

    @Test
    public void testATotalOf357BahnhoefeParsedIntoDB() {
        assertEquals(357, bahnhofLocationRepository.count());
    }
}