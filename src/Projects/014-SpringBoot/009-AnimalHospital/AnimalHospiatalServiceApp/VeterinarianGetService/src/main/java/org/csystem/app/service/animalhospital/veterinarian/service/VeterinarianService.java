package org.csystem.app.service.animalhospital.veterinarian.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;
import org.csystem.app.service.animalhospital.veterinarian.dto.CountDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithFullNameDTO;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithFullNameMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithoutCitizenIdMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeterinarianService {
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianMapper m_veterinarianMapper;
    private final IVeterinarianWithoutCitizenIdMapper m_veterinarianWithoutCitizenIdMapper;

    private final IVeterinarianWithFullNameMapper m_veterinarianWithFullNameMapper;

    public VeterinarianService(@Qualifier(BeanName.VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper veterinarianServiceHelper,
                               IVeterinarianMapper veterinarianMapper,
                               IVeterinarianWithoutCitizenIdMapper veterinarianWithoutCitizenIdMapper,
                               IVeterinarianWithFullNameMapper veterinarianWithFullNameMapper)
    {
        m_veterinarianServiceHelper = veterinarianServiceHelper;
        m_veterinarianMapper = veterinarianMapper;
        m_veterinarianWithoutCitizenIdMapper = veterinarianWithoutCitizenIdMapper;
        m_veterinarianWithFullNameMapper = veterinarianWithFullNameMapper;
    }

    public CountDTO countVeterinarians()
    {
        return m_veterinarianMapper.toCountDTO(m_veterinarianServiceHelper.countVeterinarians());
    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return m_veterinarianServiceHelper.findVeterinarianById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO);
    }

    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName), m_veterinarianMapper::toVeterinarianDTO));
        //return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName).spliterator(), false)
    }
    public VeterinariansDTO findVeterinariansByMonthAndYear(int month, int year)
    {
        return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByMonthAndYear(month, year), m_veterinarianMapper::toVeterinarianDTO));
    }

    public VeterinariansWithFullNameDTO findVeterinariansByYearBetween(int begin, int end)
    {
        return m_veterinarianWithFullNameMapper.toVeterinariansDTO(
                CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByYearBetween(begin, end), m_veterinarianWithFullNameMapper::toVeterinarianWithFullName) );
    }

    //...
}
