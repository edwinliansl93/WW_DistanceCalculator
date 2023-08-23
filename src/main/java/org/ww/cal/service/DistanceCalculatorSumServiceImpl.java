package org.ww.cal.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ww.cal.constants.CommonConstants;
import org.ww.cal.dto.CalculateDistanceReqDto;
import org.ww.cal.dto.CalculateDistanceResDto;
import org.ww.cal.entity.DistanceFormula;
import org.ww.cal.repo.DistanceFormulaRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DistanceCalculatorSumServiceImpl implements DistanceCalculatorService{

    @Autowired
    DistanceFormulaRepository distanceFormulaRepository;

    @Override
    public Map<String, String> calculateDistance(CalculateDistanceReqDto calculateDistanceReqDto) {
        List<DistanceFormula> results = distanceFormulaRepository.findAll();

        Map<String, String> result = new HashMap<>();
        if(!results.isEmpty()){

            //Before Convert
            BigDecimal value1 = new BigDecimal(calculateDistanceReqDto.getValue1());
            BigDecimal value2 = new BigDecimal(calculateDistanceReqDto.getValue2());


            Optional<DistanceFormula> dataOptional1 = results.stream()
                    .filter(data -> StringUtils.equalsIgnoreCase(data.getCode(), calculateDistanceReqDto.getUnit1()) )
                    .findFirst();

            Optional<DistanceFormula> dataOptional2 = results.stream()
                    .filter(data -> StringUtils.equalsIgnoreCase(data.getCode(), calculateDistanceReqDto.getUnit2()) )
                    .findFirst();

            Optional<DistanceFormula> dataOptional3 = results.stream()
                    .filter(data -> StringUtils.equalsIgnoreCase(data.getCode(), calculateDistanceReqDto.getSumInUnit()) )
                    .findFirst();

            DistanceFormula distanceFormula1 = new DistanceFormula();
            DistanceFormula distanceFormula2 = new DistanceFormula();
            DistanceFormula distanceFormulaFinal = new DistanceFormula();

            if (dataOptional1.isPresent() && dataOptional2.isPresent() && dataOptional3.isPresent()) {
                distanceFormula1 = dataOptional1.get();
                distanceFormula2 = dataOptional2.get();
                distanceFormulaFinal = dataOptional3.get();

                System.out.println("Code 1: " + distanceFormula1.getCode() + ", Code 2: " + distanceFormula2.getCode());
            } else {
                System.out.println("Data with code '" + calculateDistanceReqDto.getUnit1() + "' found : "+ dataOptional1.isPresent());
                System.out.println("Data with code '" + calculateDistanceReqDto.getUnit2() + "' found : "+ dataOptional2.isPresent());
                System.out.println("Data with code '" + calculateDistanceReqDto.getSumInUnit() + "' found : "+ dataOptional3.isPresent());

            }

            //Yard will be use as a base for conversion
            value1 = convertToYard(value1, distanceFormula1.getFromCurrentToYard());
            value2 = convertToYard(value2, distanceFormula2.getFromCurrentToYard());

            //total in yard and will convert to the respective sum in unit pass by user
            BigDecimal total = value1.add(value2);
            if(!StringUtils.equalsIgnoreCase(CommonConstants.BASE_CONVERTION_UNIT, calculateDistanceReqDto.getSumInUnit())){
                total = total.multiply(distanceFormulaFinal.getFromYardToCurrent());
            }

            result.put("total", total.setScale(2, RoundingMode.FLOOR).toString());
        }

        return result;
    }

    public BigDecimal convertToYard( BigDecimal value, BigDecimal conversionUnit){

            return value.multiply(conversionUnit);
    }
}
