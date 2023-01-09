package fr.mns.arthur.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.mns.arthur.model.Rights;
import fr.mns.arthur.model.User;
import fr.mns.arthur.services.rights.RightsService;
import fr.mns.arthur.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rights")
@AllArgsConstructor
public class RightsController {

    private final RightsService rightsService;

    @PostMapping("/create")
    public Rights create(@RequestBody Rights rights) {
        return rightsService.createRights(rights);
    }

    @GetMapping("/list")
    @JsonView(UserView.class)
    public List<Rights> userList() {
        return rightsService.rightsList();
    }

    @GetMapping("/{id}")
    public Rights userById(@PathVariable Long id) {
        return rightsService.rights(id);
    }

    @PutMapping("/update/{id}")
    public Rights update(@PathVariable Long id,@RequestBody Rights rights) {
        return rightsService.update(id, rights);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return rightsService.deleteRights(id);
    }

}
