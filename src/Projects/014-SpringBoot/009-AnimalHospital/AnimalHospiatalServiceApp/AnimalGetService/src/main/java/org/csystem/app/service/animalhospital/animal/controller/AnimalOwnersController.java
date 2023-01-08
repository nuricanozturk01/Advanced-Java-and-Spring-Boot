package org.csystem.app.service.animalhospital.animal.controller;

import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.service.AnimalAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/animalowners")
public class AnimalOwnersController {
    private final AnimalAppService m_animalAppService;

    public AnimalOwnersController(AnimalAppService animalAppService)
    {
        m_animalAppService = animalAppService;
    }

    @GetMapping("owners/diploma")
    public AnimalsOwnerDetailsDTO findByAnimalsOwnersByDiplomaNo(@RequestParam("no") long diplomaNo)
    {
        return m_animalAppService.findAnimalsByOwnersByDiplomaNo(diplomaNo);
    }
}