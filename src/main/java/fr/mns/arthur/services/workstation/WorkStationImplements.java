package fr.mns.arthur.services.workstation;

import fr.mns.arthur.model.WorkStation;
import fr.mns.arthur.repository.WorkStationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.velocity.exception.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkStationImplements implements WorkStationService {

    private final WorkStationRepository workStationRepository;

    @Override
    public WorkStation createWorkStation(WorkStation workStation) {
        return workStationRepository.save(workStation);
    }

    @Override
    public List<WorkStation> workStationList() {
        return workStationRepository.findAll();
    }

    @Override
    public WorkStation workStation(Long id) {
        return workStationRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Work station not found with ID: " + id + " . Please make sure this work station exist."));
    }

    @Override
    public WorkStation update(Long id, WorkStation workStation) {
        return workStationRepository.findById(id).map(w -> {
            w.setTitle(workStation.getTitle());
            w.setDescription(workStation.getDescription());
            return workStationRepository.save(w);
        }).orElseThrow(() -> new RuntimeException("Work station not found"));
    }

    @Override
    public String deleteWorkStation(Long id) {
        workStationRepository.deleteById(id);
        return "Warning : Work station "+ id + " has been deleted !";
    }
}
