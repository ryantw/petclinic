package io.lker.petclinic.services;

import io.lker.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findbyId(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
