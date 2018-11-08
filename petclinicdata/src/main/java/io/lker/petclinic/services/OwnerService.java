package io.lker.petclinic.services;

import io.lker.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner findbyId(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}