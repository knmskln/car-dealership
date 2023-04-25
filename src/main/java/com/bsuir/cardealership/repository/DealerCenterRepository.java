package com.bsuir.cardealership.repository;

import com.bsuir.cardealership.model.DealerCenter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DealerCenterRepository extends JpaRepository<DealerCenter, Long> {
DealerCenter getDealerCenterById(Long dealerCenterId);
}
