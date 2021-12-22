package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.domain.*;
import guru.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Doe");
        owner1.setAddress("132 Brookline");
        owner1.setCity("Brookline");
        owner1.setTelephone("322626555");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
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
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setPetType(savedCatPetType);
        owner2.getPets().add(johnsPet);


        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(johnsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneeze Kitty");

        visitService.save(catVisit);

        System.out.println("Loading owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ax");
        vet1.setLastName("Ax");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sem");
        vet2.setLastName("Sem");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loading vets ...");
    }
}
