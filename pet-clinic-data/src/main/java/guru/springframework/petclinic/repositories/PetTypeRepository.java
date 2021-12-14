package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.domain.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
