package guru.springframework.petclinic.services;

import guru.springframework.petclinic.domain.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
