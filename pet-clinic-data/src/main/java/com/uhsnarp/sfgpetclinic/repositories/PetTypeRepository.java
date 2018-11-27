package com.uhsnarp.sfgpetclinic.repositories;

import com.uhsnarp.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
