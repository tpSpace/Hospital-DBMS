package com.application.HPDM.Nurse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    public Nurse findByNurseNameIgnoreCase(String nurseName);

}
