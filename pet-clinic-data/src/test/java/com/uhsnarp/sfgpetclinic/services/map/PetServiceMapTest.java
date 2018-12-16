package com.uhsnarp.sfgpetclinic.services.map;

import com.uhsnarp.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    private final Long petId = 1L;
    private PetServiceMap peServiceMap;

    @BeforeEach
    void setUp() {
        peServiceMap = new PetServiceMap();
        peServiceMap.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = peServiceMap.findAll();
        assertEquals(1, petSet.size());
    }

    @Test
    void findByIdExistingId() {
        Pet pet = peServiceMap.findById(petId);
        assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {
        Pet pet = peServiceMap.findById(5L);
        assertNull(pet);
    }

    @Test
    void findByIdNullId() {
        Pet pet = peServiceMap.findById(null);
        assertNull(pet);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = peServiceMap.save(pet2);
        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {
        Long id = 1L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = peServiceMap.save(pet2);
        assertEquals(id, savedPet.getId());
        assertEquals(1, peServiceMap.findAll().size());
    }

    @Test
    void saveNoId() {
        Pet savedPet = peServiceMap.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, peServiceMap.findAll().size());
    }

    @Test
    void deletePet() {
        peServiceMap.delete(peServiceMap.findById(petId));
        assertEquals(0, peServiceMap.findAll().size());
    }

    @Test
    void deleteWithWrongId() {
        Pet pet = Pet.builder().id(5L).build();
        peServiceMap.delete(pet);
        assertEquals(1, peServiceMap.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        Pet pet = Pet.builder().build();
        peServiceMap.delete(pet);
        assertEquals(1, peServiceMap.findAll().size());
    }

    @Test
    void deleteNull() {
        peServiceMap.delete(null);
        assertEquals(1, peServiceMap.findAll().size());
    }

    @Test
    void deleteByIdCorrectId() {
        peServiceMap.deleteById(petId);
        assertEquals(0, peServiceMap.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {
        peServiceMap.deleteById(5L);
        assertEquals(1, peServiceMap.findAll().size());
    }

    @Test
    void deleteByIdNullId() {
        peServiceMap.deleteById(null);
        assertEquals(1, peServiceMap.findAll().size());
    }
}