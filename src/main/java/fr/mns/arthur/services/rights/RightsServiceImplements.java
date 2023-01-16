package fr.mns.arthur.services.rights;

import fr.mns.arthur.model.Rights;
import fr.mns.arthur.model.User;
import fr.mns.arthur.repository.RightsRepository;
import fr.mns.arthur.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RightsServiceImplements implements RightsService {

    private final RightsRepository rightsRepository;

    @Override
    public Rights createRights(Rights rights) {
        return rightsRepository.save(rights);
    }

    @Override
    public List<Rights> rightsList() {
        return rightsRepository.findAll();
    }

    @Override
    public Rights rights(Long id) {
        return rightsRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Rights not found with ID: " + id + " . Please make sure this project exist."));
    }

    @Override
    public Rights update(Long id, Rights rights) {
        return rightsRepository.findById(id).map(r -> {
            r.setLabel(rights.getLabel());
            return rightsRepository.save(r);
        }).orElseThrow(() -> new RuntimeException("Rights not found"));
    }

    @Override
    public String deleteRights(Long id) {
        rightsRepository.deleteById(id);
        return "Warning : Rights "+ id + " has been deleted !";
    }
}
