package com.application.HPDM.TakeCare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeCareRespository extends JpaRepository<TakeCare, Long> {
}
