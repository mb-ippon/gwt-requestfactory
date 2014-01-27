package com.ippon.formation.gwt.client.domain.bindery.rf.proxy;

import java.util.Date;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.server.domain.facade.PlayerLocator;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

@ProxyFor(value = PlayerEntity.class, locator = PlayerLocator.class)
public interface PlayerProxy extends EntityProxy {

    CountryProxy getCountry();

    void setCountry(CountryProxy country);

    void setVersion(Integer version);

    void setBirthDay(Date birthDay);

    void setAtpPoint(Integer atpPoint);

    String getName();

    void setName(String name);

    Date getBirthDay();

    void setTurnedPro(Date birthDay);

    int getHeight();

    void setHeight(int height);

    int getWeight();

    void setWeight(int weight);

    int getYearTurnPro();

    void setYearTurnPro(int yearTurnPro);

    Plays getPlayHand();

    void setPlayHand(Plays playHand);

    Integer getAtpPoint();

    void setAtpPoint(int atpPoint);
}
