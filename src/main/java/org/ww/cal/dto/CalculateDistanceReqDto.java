package org.ww.cal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculateDistanceReqDto {

    @NotBlank
    @NotNull(message = "Value must not be null")
    private String unit1;

    @NotBlank
    @NotNull(message = "Value must not be null")
    private String value1;

    @NotBlank
    @NotNull(message = "Value must not be null")
    private String unit2;

    @NotBlank
    @NotNull(message = "Value must not be null")
    private String value2;

    @NotBlank
    @NotNull(message = "Value must not be null")
    private String sumInUnit;
}
