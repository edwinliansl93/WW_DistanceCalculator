package org.ww.cal.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ww.cal.dto.CalculateDistanceReqDto;
import org.ww.cal.dto.CalculateDistanceResDto;
import org.ww.cal.service.DistanceCalculatorSumServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/api/ww")
@Validated
public class CalculateDistanceController {

    @Autowired
    DistanceCalculatorSumServiceImpl distanceCalculatorSumService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateSum(@RequestBody @Valid CalculateDistanceReqDto calculateDistanceReqDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // If validation errors are present, build an error response
            StringBuilder errorResponse = new StringBuilder();
            bindingResult.getAllErrors().forEach(error ->
                    errorResponse.append(error.getDefaultMessage()).append("; ")
            );
            CalculateDistanceResDto<String> response = new CalculateDistanceResDto<>(HttpStatus.BAD_REQUEST,errorResponse.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            CalculateDistanceResDto<Map<String,String>> response = new CalculateDistanceResDto<>(HttpStatus.OK,distanceCalculatorSumService.calculateDistance(calculateDistanceReqDto));
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        }

    }
}
