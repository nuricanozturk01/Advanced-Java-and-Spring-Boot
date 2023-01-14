package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Animal;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.repository.IAnimalOwnerRepository;
import com.metemengen.animalhospital.data.repository.IAnimalRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.ANIMAL_SERVICE_HELPER)
@Lazy
public class AnimalServiceHelper {
    private final IAnimalOwnerRepository m_animalOwnerRepository;

    private final IAnimalRepository m_animalRepository;

    public AnimalServiceHelper(@Qualifier(BeanName.ANIMAL_OWNER_REPOSITORY) IAnimalOwnerRepository animalOwnerRepository,
                               IAnimalRepository animalRepository)
    {
        m_animalOwnerRepository = animalOwnerRepository;
        m_animalRepository = animalRepository;
    }

    public Iterable<AnimalOwnerDetails> findAnimalOwnerDetailsByDiplomaNo(long diplomaNo)
    {
        return m_animalOwnerRepository.findByDiplomaNo(diplomaNo);
    }

    public Optional<Animal> findAnimalById(int id)
    {
        return m_animalRepository.findById(id);
    }

    public Iterable<Animal> findAnimalsByNameContainsAndSterile(String text, boolean sterile)
    {
        return m_animalRepository.findByNameContainsAndSterile(text, sterile);
    }

    public Iterable<Animal> findAnimalsByType(String type)
    {
        return m_animalRepository.findByType(type);
    }

    public Iterable<Animal> findAnimalsByMonthAndYear(int month, int year)
    {
        return m_animalRepository.findByMonthAndYear(month, year);
    }

    //...
}
