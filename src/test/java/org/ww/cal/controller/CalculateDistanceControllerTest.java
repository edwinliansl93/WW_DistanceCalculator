package org.ww.cal.controller;

import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ww.cal.dto.CalculateDistanceReqDto;
import org.ww.cal.dto.CalculateDistanceResDto;
import org.ww.cal.service.DistanceCalculatorSumServiceImpl;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(CalculateDistanceController.class)
public class CalculateDistanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistanceCalculatorSumServiceImpl distanceCalculatorSumService;

    @Test
    public void testCalculateSum_Success() throws Exception {
        Map<String, String> result = new HashMap<>();
        result.put("total", "7.74");

        String requestBody = "{\n" +
                "  \"unit1\": \"yards\",\n" +
                "  \"value1\": \"3\",\n" +
                "  \"unit2\": \"meters\",\n" +
                "  \"value2\": \"5\",\n" +
                "  \"sumInUnit\": \"meters\"\n" +
                "}";

        when(distanceCalculatorSumService.calculateDistance(any())).thenReturn(result);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/ww/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.total").value("7.74"));

        verify(distanceCalculatorSumService, times(1)).calculateDistance(any());
    }

    @Test
    public void testCalculateSum_Failed() throws Exception {

        String requestBody = "{\n" +
                "  \"unit1\": \"\",\n" +
                "  \"value1\": \"3\",\n" +
                "  \"unit2\": \"meters\",\n" +
                "  \"value2\": \"5\",\n" +
                "  \"sumInUnit\": \"meters\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/ww/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
