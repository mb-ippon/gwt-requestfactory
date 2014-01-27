package com.ippon.formation.gwt.server.service;

import java.util.List;

import com.ippon.formation.gwt.server.domain.dao.CountryDao;
import com.ippon.formation.gwt.server.domain.dao.CountryDaoImpl;
import com.ippon.formation.gwt.server.domain.entities.CountryEntity;

public class CountryServiceImpl implements CountryService {

    private final CountryDao dao = new CountryDaoImpl();

    @Override
    public List<CountryEntity> findCountries() {
        return dao.findCountries();
    }

    @Override
    public CountryEntity findCountry(Long id) {
        return dao.findCountry(id);
    }

}
