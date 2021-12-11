package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.domain.Owner;
import guru.springframework.petclinic.domain.Pet;
import guru.springframework.petclinic.domain.PetType;
import guru.springframework.petclinic.domain.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

     private final OwnerService ownerService;
     private final VetService vetService;
     private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Doe");
        owner1.setAddress("132 Brookline");
        owner1.setCity("Brookline");
        owner1.setTelephone("322626555");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDay(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Johnathan");
        owner2.setLastName("Pitcher");
        owner2.setAddress("1377 Brookline");
        owner2.setCity("Brookline");
        owner2.setTelephone("322776555");

        Pet johnsPet = new Pet();
        johnsPet.setName("just cat");
        johnsPet.setOwner(owner2);
        johnsPet.setBirthDay(LocalDate.now());
        johnsPet.setPetType(savedCatPetType);
        owner2.getPets().add(johnsPet);


        ownerService.save(owner2);

        System.out.println("Loading owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ax");
        vet1.setLastName("Ax");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sem");
        vet2.setLastName("Sem");

        vetService.save(vet2);

        System.out.println("Loading vets ...");




    }
}
