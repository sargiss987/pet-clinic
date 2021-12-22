package guru.springframework.petclinic.services;

import guru.springframework.petclinic.domain.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
