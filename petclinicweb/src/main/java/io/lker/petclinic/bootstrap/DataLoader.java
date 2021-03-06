package io.lker.petclinic.bootstrap;


import io.lker.petclinic.model.*;
import io.lker.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Spring bean, registered in to Spring Context
// When Spring context is up and ready, CommandLineRunner -> run()
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);


        PetType dog = new PetType();
        dog.setName("Hank");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Lloyd");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alicia");
        owner1.setLastName("Walker");
        owner1.setAddress("123 Bell Lane");
        owner1.setCity("Hot Springs");
        owner1.setTelephone("123-456-7890");

        Pet aliciasPet = new Pet();
        aliciasPet.setPetType(savedDogPetType);
        aliciasPet.setOwner(owner1);
        aliciasPet.setBirthDate(LocalDate.now());
        aliciasPet.setName("Hank");
        owner1.getPets().add(aliciasPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Annsley");
        owner2.setLastName("Walker");
        owner2.setAddress("21 Oxmoor Dr");
        owner2.setCity("Etown");
        owner2.setTelephone("321-654-7890");

        Pet annsleysPet = new Pet();
        annsleysPet.setPetType(savedCatPetType);
        annsleysPet.setOwner(owner2);
        annsleysPet.setBirthDate(LocalDate.now());
        annsleysPet.setName("Lloyd");
        owner2.getPets().add(annsleysPet);
        ownerService.save(owner2);

        Visit llyodVisit = new Visit();
        llyodVisit.setPet(annsleysPet);
        llyodVisit.setDate(LocalDate.now());
        llyodVisit.setDescription("Too fat.");
        visitService.save(llyodVisit);

        Owner owner3 = new Owner();
        owner3.setFirstName("John");
        owner3.setLastName("Smith");
        owner3.setAddress("21 Oxmoor Dr");
        owner3.setCity("Etown");
        owner3.setTelephone("321-654-7890");
        ownerService.save(owner3);


        /** VETS **/
        Vet vet1 = new Vet();
        vet1.setFirstName("Ava");
        vet1.setLastName("Walker");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ryan");
        vet2.setLastName("Walker");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
    }
}
