package com.ippon.formation.gwt.server.service;

import java.util.List;

import com.ippon.formation.gwt.server.domain.entities.CountryEntity;

public interface CountryService {
    List<CountryEntity> findCountries();

    CountryEntity findCountry(Long id);
}
