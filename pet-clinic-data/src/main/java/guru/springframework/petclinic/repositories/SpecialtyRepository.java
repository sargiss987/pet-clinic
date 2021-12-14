package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.domain.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
