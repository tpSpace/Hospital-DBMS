package com.application.HPDM.TakeCare;

import java.util.List;

public interface TakeCareService {
    TakeCare saveTakeCare(TakeCare takeCare);
    List<TakeCare> fetchTakeCareList();
    TakeCare fetchTakeCareByPatientID(Long patientId);
    TakeCare fetchTakeCareByDoctorID(Long doctorId);
}
