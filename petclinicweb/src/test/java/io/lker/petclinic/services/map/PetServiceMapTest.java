package io.lker.petclinic.services.map;

import io.lker.petclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    PetServiceMap petServiceMap;
    final String name = "Ralph";
    final Long id = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(id).name(name).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();
        assertNotNull(pets);
        assertEquals(1,pets.size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(id);
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(id));
        assertEquals(0, petServiceMap.findAll().size());

    }

    @Test
    void save() {
        Pet savedPet = petServiceMap.save(Pet.builder().name(name).build());
        assertEquals("Ralph", savedPet.getName());
    }

    @Test
    void findById() {
        Pet found = petServiceMap.findById(1L);
        assertEquals(id, found.getId());
    }
}