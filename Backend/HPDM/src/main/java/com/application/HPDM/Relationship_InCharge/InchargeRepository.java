package com.application.HPDM.Relationship_InCharge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InchargeRepository extends JpaRepository<Incharge,Long> {

}
