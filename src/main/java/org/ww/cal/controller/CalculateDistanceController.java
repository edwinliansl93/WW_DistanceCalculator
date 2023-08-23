package org.ww.cal.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ww.cal.dto.CalculateDistanceReqDto;
import org.ww.cal.dto.CalculateDistanceResDto;
import org.ww.cal.service.DistanceCalculatorSumServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/api/ww")
public class CalculateDistanceController {

    @Autowired
    DistanceCalculatorSumServiceImpl distanceCalculatorSumService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateSum(@RequestBody @Valid CalculateDistanceReqDto calculateDistanceReqDto) {
        try {
            CalculateDistanceResDto<Map<String,String>> response = new CalculateDistanceResDto<>(HttpStatus.OK,distanceCalculatorSumService.calculateDistance(calculateDistanceReqDto));
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        }
    }

}
