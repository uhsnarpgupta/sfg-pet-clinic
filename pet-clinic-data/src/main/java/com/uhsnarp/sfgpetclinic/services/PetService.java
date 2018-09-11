package com.uhsnarp.sfgpetclinic.services;

import com.uhsnarp.sfgpetclinic.model.Pet;

public interface PetService extends CrudService<Pet, Long>{
    Pet save(Pet pet);
}
