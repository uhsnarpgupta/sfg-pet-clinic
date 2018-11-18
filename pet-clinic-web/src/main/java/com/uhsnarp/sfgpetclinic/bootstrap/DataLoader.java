package com.uhsnarp.sfgpetclinic.bootstrap;

import com.uhsnarp.sfgpetclinic.model.Owner;
import com.uhsnarp.sfgpetclinic.model.PetType;
import com.uhsnarp.sfgpetclinic.model.Vet;
import com.uhsnarp.sfgpetclinic.services.OwnerService;
import com.uhsnarp.sfgpetclinic.services.PetTypeService;
import com.uhsnarp.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //Befor Spring 2 @Autowired was required on constructor as well
    //@Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    /* public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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
