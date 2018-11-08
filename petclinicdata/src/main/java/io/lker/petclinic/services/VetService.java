package io.lker.petclinic.services;

import io.lker.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastName);
    Vet findbyId(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
