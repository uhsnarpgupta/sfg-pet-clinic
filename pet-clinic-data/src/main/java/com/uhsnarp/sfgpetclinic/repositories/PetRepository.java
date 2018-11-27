package com.uhsnarp.sfgpetclinic.repositories;

import com.uhsnarp.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
