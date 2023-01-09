package fr.mns.arthur.services.workstation;

import fr.mns.arthur.model.WorkStation;

import java.util.List;

public interface WorkStationService {

    WorkStation createWorkStation(WorkStation workStation);

    List<WorkStation> workStationList();

    WorkStation workStation(Long id);

    WorkStation update(Long id, WorkStation workStation);

    String deleteWorkStation(Long id);
}
