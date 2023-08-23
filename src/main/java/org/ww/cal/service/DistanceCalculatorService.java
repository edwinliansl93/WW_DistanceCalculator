package org.ww.cal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ww.cal.dto.CalculateDistanceReqDto;
import org.ww.cal.dto.CalculateDistanceResDto;
import org.ww.cal.repo.DistanceFormulaRepository;

import java.util.Map;

@Service
public interface DistanceCalculatorService {

    public Map<String, String> calculateDistance(CalculateDistanceReqDto calculateDistanceReqDto);

}
