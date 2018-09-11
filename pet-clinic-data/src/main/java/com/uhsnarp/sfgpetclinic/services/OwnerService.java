package com.uhsnarp.sfgpetclinic.services;

import com.uhsnarp.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
