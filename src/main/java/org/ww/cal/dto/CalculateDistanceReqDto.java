package org.ww.cal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculateDistanceReqDto {

    private String unit1;
    private String value1;
    private String unit2;
    private String value2;
    private String sumInUnit;
}
