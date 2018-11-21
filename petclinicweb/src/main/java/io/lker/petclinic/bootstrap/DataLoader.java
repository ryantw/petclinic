package io.lker.petclinic.bootstrap;


import io.lker.petclinic.model.Owner;
import io.lker.petclinic.model.Vet;
import io.lker.petclinic.services.OwnerService;
import io.lker.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
// Spring bean, registered in to Spring Context
// When Spring context is up and ready, CommandLineRunner -> run()
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Alicia");
        owner1.setLastName("Walker");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Annsley");
        owner2.setLastName("Walker");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Ava");
        vet1.setLastName("Walker");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ryan");
        vet2.setLastName("Walker");
        vetService.save(vet2);

    }
}
