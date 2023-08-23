package org.ww.cal.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "distance_formula", schema = "ww")
public class DistanceFormula {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @Column(name = "cd")
    private String code;

    @Column(name = "from_current_to_yard")
    private BigDecimal fromCurrentToYard;

    @Column(name = "from_yard_to_current")
    private BigDecimal fromYardToCurrent;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
