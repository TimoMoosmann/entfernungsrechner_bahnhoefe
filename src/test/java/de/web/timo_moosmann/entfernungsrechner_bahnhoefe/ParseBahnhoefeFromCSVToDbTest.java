package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ParseBahnhoefeFromCSVToDbTest {

    @Autowired
    private BahnhofLocationRepository repository;

    @Test
    public void testHanauHbfWasCorrectlyParsedAndCanBeFetchedByDS100() {
        BahnhofLocation expectedBahnhofLocationHanauHBF = new BahnhofLocation(
                Arrays.asList("FH", "FH  N", "FH  S"),
                "Hanau Hbf",
                8.929,
                50.120953
        );

        BahnhofLocation bahnhofLocationHanauHbfFetch1 = repository.retrieveByDS100("FH");
        BahnhofLocation bahnhofLocationHanauHbfFetch2 = repository.retrieveByDS100("FH  N");
        BahnhofLocation bahnhofLocationHanauHbfFetch3 = repository.retrieveByDS100("FH  S");

        assertEquals(expectedBahnhofLocationHanauHBF, bahnhofLocationHanauHbfFetch1);
        assertEquals(expectedBahnhofLocationHanauHBF, bahnhofLocationHanauHbfFetch2);
        assertEquals(expectedBahnhofLocationHanauHBF, bahnhofLocationHanauHbfFetch3);
    }

    @Test
    public void testJenaGoeschwitzWasCorrectlyParsedAndCanBeFetchedByDS100() {
        // UGW	de:16053:8010133	Jena-Göschwitz	FV	11,593537	50,883942
        // todo
    }

    @Test
    public void testUeberseeWasCorrectlyParsedAndCanBeFetchedByDS100() {
        // MUS	de:09189:41234	Übersee	FV	12,487338	47,822047
        // todo
    }

    @Test
    public void testATotalOf357BahnhoefeParsedIntoDB() {
        // todo
    }
}
