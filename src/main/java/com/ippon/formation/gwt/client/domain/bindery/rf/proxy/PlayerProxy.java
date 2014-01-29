package com.ippon.formation.gwt.client.domain.bindery.rf.proxy;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.server.domain.facade.PlayerLocator;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

@ProxyFor(value = PlayerEntity.class, locator = PlayerLocator.class)
public interface PlayerProxy extends EntityProxy {

    @NotNull
    CountryProxy getCountry();

    void setCountry(CountryProxy country);

    void setVersion(Integer version);

    void setBirthDay(Date birthDay);

    @NotNull
    @Size(min = 10, max = 50)
    String getName();

    void setName(String name);

    @NotNull
    @Past
    Date getBirthDay();

    void setTurnedPro(Date birthDay);

    @NotNull
    @Digits(integer = 3, fraction = 0)
    Integer getHeight();

    void setHeight(Integer height);

    @NotNull
    @Digits(integer = 3, fraction = 0)
    Integer getWeight();

    void setWeight(Integer weight);

    @NotNull
    @Digits(integer = 4, fraction = 0)
    @Min(value = 1968)
    Integer getYearTurnPro();

    void setYearTurnPro(Integer yearTurnPro);

    @NotNull
    Plays getPlayHand();

    void setPlayHand(Plays playHand);

    @NotNull
    @Min(value = 0)
    @Digits(integer = 5, fraction = 0)
    Integer getAtpPoint();

    void setAtpPoint(Integer atpPoint);
}
