package fr.mns.arthur.services.rights;

import fr.mns.arthur.model.Rights;
import fr.mns.arthur.model.User;

import java.util.List;

public interface RightsService {

    Rights createRights(Rights rights);

    List<Rights> rightsList();

    Rights rights(Long id);

    Rights update(Long id, Rights rights);

    String deleteRights(Long id);
}
