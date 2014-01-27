package com.ippon.formation.gwt.server.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.common.collect.Lists;
import com.ippon.formation.gwt.server.domain.entities.CountryEntity;
import com.ippon.formation.gwt.server.util.HibernateUtil;

public class CountryDaoImpl implements CountryDao {

    @Override
    public List<CountryEntity> findCountries() {
        EntityManager em = HibernateUtil.getEntityManager();
        List<CountryEntity> countryEntities = Lists.newArrayList();
        List<?> countries = em.createQuery("select c from Country c").getResultList();
        for (Object c : countries) {
            if (c instanceof CountryEntity) {
                countryEntities.add((CountryEntity) c);
            }
        }
        return countryEntities;
    }

    @Override
    public CountryEntity findCountry(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        CountryEntity country = em.find(CountryEntity.class, id);
        return country;
    }

}
