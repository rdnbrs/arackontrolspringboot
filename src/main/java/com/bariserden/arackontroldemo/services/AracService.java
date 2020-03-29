package com.bariserden.arackontroldemo.services;


import com.bariserden.arackontroldemo.dto.AracDto;

import java.util.List;

public interface AracService {

    AracDto save(AracDto arac);

    AracDto getById(Long id);

    List<AracDto> getAll();

}
