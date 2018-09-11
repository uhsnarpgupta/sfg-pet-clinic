package com.uhsnarp.sfgpetclinic.services;

import java.util.Set;

public interface Vet {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
