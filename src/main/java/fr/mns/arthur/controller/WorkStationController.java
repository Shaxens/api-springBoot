package fr.mns.arthur.controller;

import fr.mns.arthur.model.WorkStation;
import fr.mns.arthur.services.workstation.WorkStationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workstation")
@AllArgsConstructor
public class WorkStationController {

    private final WorkStationService workStationService;

    @PostMapping("/create")
    public WorkStation create(@RequestBody WorkStation workStation) {
        return workStationService.createWorkStation(workStation);
    }

    @GetMapping("/list")
    public List<WorkStation> userList() {
        return workStationService.workStationList();
    }

    @GetMapping("/{id}")
    public List<WorkStation> workStationById(@PathVariable Long id) {
        return workStationService.workStationList();
    }

    @PutMapping("/update/{id}")
    public WorkStation update(@PathVariable Long id,@RequestBody WorkStation workStation) {
        return workStationService.update(id, workStation);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return workStationService.deleteWorkStation(id);
    }

}
