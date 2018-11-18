package com.uhsnarp.sfgpetclinic.services;

import com.uhsnarp.sfgpetclinic.model.PetType;

public interface PetTypeService extends CrudService<PetType, Long>{
    PetType save(PetType petType);
}
