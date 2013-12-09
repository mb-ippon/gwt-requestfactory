package com.ippon.formation.gwt.server.domain.dao;

import java.util.List;

import com.ippon.formation.gwt.server.domain.entities.CountryEntity;

public interface CountryDao {

    CountryEntity findCountry(Long id);

    List<CountryEntity> findCountries();

}
