package org.ww.cal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ww.cal.entity.DistanceFormula;

import java.util.UUID;

@Repository
public interface DistanceFormulaRepository extends JpaRepository<DistanceFormula, UUID> {
}

