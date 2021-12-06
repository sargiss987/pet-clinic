package guru.springframework.petclinic.services;

import guru.springframework.petclinic.domain.Owner;

import java.util.Set;

public interface OwnerService {

    //git
    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();


}
