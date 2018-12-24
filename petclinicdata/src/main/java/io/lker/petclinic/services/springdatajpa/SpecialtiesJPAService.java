package io.lker.petclinic.services.springdatajpa;

import io.lker.petclinic.model.Specialty;
import io.lker.petclinic.repositories.specialtiesRepository;
import io.lker.petclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtiesJPAService implements SpecialtiesService {

    private final specialtiesRepository specialtiesRepository;

    public SpecialtiesJPAService(specialtiesRepository specialtiesRepository) {
        this.specialtiesRepository = specialtiesRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtiesRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtiesRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtiesRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtiesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtiesRepository.deleteById(aLong);
    }
}
