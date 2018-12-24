package io.lker.petclinic.repositories;

import io.lker.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface specialtiesRepository extends CrudRepository<Specialty, Long> {
}
