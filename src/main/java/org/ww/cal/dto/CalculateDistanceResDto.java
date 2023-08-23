package org.ww.cal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculateDistanceResDto<T> {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private T data;

    public CalculateDistanceResDto(HttpStatus status, T data) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.data = data;
    }
}
