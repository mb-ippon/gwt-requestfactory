package com.ippon.formation.gwt.server.domain.dao;

import java.util.List;

import org.hibernate.Session;

import com.google.common.collect.Lists;
import com.ippon.formation.gwt.server.domain.entities.CountryEntity;
import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.server.util.HibernateUtil;

public class CountryDaoImpl implements CountryDao {

    @Override
    public CountryEntity findCountry(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        CountryEntity country = (CountryEntity) session.load(CountryEntity.class, id);
        return country;
    }

    @Override
    public List<CountryEntity> findCountries() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CountryEntity> countryEntities = Lists.newArrayList();
        List<?> players = session.createQuery("select c from Country c").list();
        for (Object p : players) {
            if (p instanceof PlayerEntity) {
                countryEntities.add((CountryEntity) p);
            }
        }
        return countryEntities;
    }

}
