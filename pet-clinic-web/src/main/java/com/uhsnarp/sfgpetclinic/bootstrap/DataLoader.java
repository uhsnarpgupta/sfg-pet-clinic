package com.uhsnarp.sfgpetclinic.bootstrap;

import com.uhsnarp.sfgpetclinic.model.Owner;
import com.uhsnarp.sfgpetclinic.model.Vet;
import com.uhsnarp.sfgpetclinic.services.OwnerService;
import com.uhsnarp.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    //Befor Spring 2 @Autowired was required on constructor as well
    //@Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    /* public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Mary");
        owner1.setLastName("Kom");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Baichung");
        owner2.setLastName("Bhutia");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Michael");
        vet1.setLastName("Jordan");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Tom");
        vet2.setLastName("Hearry");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
