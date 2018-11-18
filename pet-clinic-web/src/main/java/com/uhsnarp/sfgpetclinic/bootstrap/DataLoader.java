package com.uhsnarp.sfgpetclinic.bootstrap;

import com.uhsnarp.sfgpetclinic.model.*;
import com.uhsnarp.sfgpetclinic.services.OwnerService;
import com.uhsnarp.sfgpetclinic.services.PetTypeService;
import com.uhsnarp.sfgpetclinic.services.SpecialityService;
import com.uhsnarp.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    //Befor Spring 2 @Autowired was required on constructor as well
    //@Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    /* public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0){
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
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Mary");
        owner1.setLastName("Kom");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1234343232");

        Pet marysPet = new Pet();
        marysPet.setPetType(savedDogPetType);
        marysPet.setOwner(owner1);
        marysPet.setBirthDate(LocalDate.now());
        marysPet.setName("Rosco");

        owner1.getPets().add(marysPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Baichung");
        owner2.setLastName("Bhutia");
        owner2.setAddress("China Waali Gali");
        owner2.setCity("Imphal");
        owner2.setTelephone("1234343232");

        Pet baichungsPet = new Pet();
        baichungsPet.setPetType(savedCatPetType);
        baichungsPet.setOwner(owner2);
        baichungsPet.setBirthDate(LocalDate.now());
        baichungsPet.setName("Just Cat");
        owner2.getPets().add(baichungsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Jordan");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Tom");
        vet2.setLastName("Hearry");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
        System.out.println("Loaded Vets...");

    }
}
