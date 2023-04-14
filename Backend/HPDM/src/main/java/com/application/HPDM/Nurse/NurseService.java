package com.application.HPDM.Nurse;

import java.util.List;

public interface NurseService {
    Nurse saveNurse(Nurse nurse);

    Nurse fetchNurseByID(Long nurseID);

    Nurse fetchNurseByName(String nurseName);

    void deleteNurseByID(Long nurseID);

    List<Nurse> fetchNurseList();

    Nurse updateNurse(Long nurseID, Nurse nurse);
}
