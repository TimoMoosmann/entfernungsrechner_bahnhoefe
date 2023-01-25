package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ParseBahnhoefeToCSVTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHanauHbfWasCorrectlyParsedAndIsFetchabelFromDB() {
        /*
        BahnhofLocation expectedBahnhofLocationHanauHBF = new BahnhofLocation(
                "FH"
        )
         */
    }

    // Possible Tests:
    // Fetche 3 Zeilen aus der DB (Fernabahnhöfe, am besten Special cases) -> Checke mit Mock Object ob alles passt.
    // Parse by ds100 -> Ein Bahnhof mit verschiedenen DS 100 ausprobieren (Hanau)
    //
    // Zähle alle Entires ~ 360

    // Testfälle
    // Hanau mit allen Möglichen ds100 fetchen -> Erwarte immer gleiches Ergebnis.
    // ...
}
