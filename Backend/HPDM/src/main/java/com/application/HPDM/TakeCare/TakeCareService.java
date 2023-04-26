package com.application.HPDM.TakeCare;

import java.util.List;

public interface TakeCareService {
    TakeCare saveTakeCare(TakeCare takeCare);
    List<TakeCare> fetchTakeCareList();
    List<TakeCare> fetchTakeCareByPatientID(Long patientId);
    List<TakeCare> fetchTakeCareByNurseID(Long nurseId);
}
