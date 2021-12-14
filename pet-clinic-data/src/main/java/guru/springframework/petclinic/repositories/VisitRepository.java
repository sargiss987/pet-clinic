package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
