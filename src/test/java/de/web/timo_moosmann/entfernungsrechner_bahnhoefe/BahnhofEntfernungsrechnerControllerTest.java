package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BahnhofEntfernungsrechnerControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testDistanceFromFFToBLS() throws Exception {
        BahnhoefeDistance mockedDistanceFFToBLS = new BahnhoefeDistance(
                "Frankfurt(Main)Hbf",
                "Berlin Hbf",
                423
        );
        testExpectBahnhofDistanceObjectWithSuccess("/api/v1/distance/FF/BLS", mockedDistanceFFToBLS);
    }

    @Test
    public void testDistanceFromBLSToFF() throws Exception {
        BahnhoefeDistance mockedDistanceBLSToFF = new BahnhoefeDistance(
                "Berlin Hbf",
                "Frankfurt(Main)Hbf",
                423
        );
        testExpectBahnhofDistanceObjectWithSuccess("/api/v1/distance/BLS/FF", mockedDistanceBLSToFF);
    }

    @Test
    public void testDistanceFromFFToFF() throws Exception {
        BahnhoefeDistance mockedDistanceBLSToFF = new BahnhoefeDistance(
                "Frankfurt(Main)Hbf",
                "Frankfurt(Main)Hbf",
                0
        );
        testExpectBahnhofDistanceObjectWithSuccess("/api/v1/distance/FF/FF", mockedDistanceBLSToFF);
    }

    @Test
    public void testStartDS100IsInvalid() throws Exception {
        testExpectErrorMessageWithBadRequest(
                "/api/v1/distance/XYZ/FF",
                "Could not find Bahnhof with DS100 Code: XYZ"
        );
    }

    @Test
    public void testDestinationDS100IsInvalid() throws Exception {
        testExpectErrorMessageWithBadRequest(
                "/api/v1/distance/FF/XYZ",
                "Could not find Bahnhof with DS100 Code: XYZ"
        );
    }

    private void testExpectBahnhofDistanceObjectWithSuccess(
            String requestPath, BahnhoefeDistance mockedDistance
    ) throws Exception {
        final String expectedResponseContent = objectMapper.writeValueAsString(mockedDistance);

        mvc.perform(MockMvcRequestBuilders.get(requestPath).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseContent));
    }

    private void testExpectErrorMessageWithBadRequest(String requestPath, String errorMessage) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(requestPath).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(errorMessage));
    }
}
