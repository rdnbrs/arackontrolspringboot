package com.bariserden.arackontroldemo.services.impl;

import com.bariserden.arackontroldemo.dto.AracDto;
import com.bariserden.arackontroldemo.entity.Arac;
import com.bariserden.arackontroldemo.repo.AracRepository;
import com.bariserden.arackontroldemo.services.AracService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AracServiceImpl implements AracService {

    @Autowired
    AracRepository aracRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public AracDto save(AracDto arac) {
        if (arac.getAracAdi() == null) {
            throw new IllegalArgumentException("Araç Adı Boş Olamaz!");
        }
        Arac projectDb = modelMapper.map(arac,Arac.class);
        projectDb = aracRepository.save(projectDb);
        return modelMapper.map(projectDb,AracDto.class);
    }

    @Override
    public AracDto getById(Long id) {
        Arac p = aracRepository.getOne(id);
        return modelMapper.map(p,AracDto.class);
    }

    @Override
    public List<AracDto> getAll() {
        List<Arac> araclar = aracRepository.findAll();
        AracDto[] aracDtos = modelMapper.map(araclar,AracDto[].class);
        return Arrays.asList(aracDtos);
    }
}
