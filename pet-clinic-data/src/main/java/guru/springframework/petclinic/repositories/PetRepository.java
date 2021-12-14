package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.domain.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
