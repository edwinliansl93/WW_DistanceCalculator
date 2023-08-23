package org.ww.cal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ww.cal.dto.CalculateDistanceReqDto;

@RestController
@RequestMapping("/api/ww")
public class CalculateDistanceController {

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateSum(@RequestBody CalculateDistanceReqDto calculateDistanceReqDto) {
        try {

            return ResponseEntity.ok("Test");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        }
    }

}
