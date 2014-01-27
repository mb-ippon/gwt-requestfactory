package com.ippon.formation.gwt.client.domain.bindery.rf.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.ippon.formation.gwt.server.domain.entities.CountryEntity;
import com.ippon.formation.gwt.server.domain.facade.CountryLocator;

@ProxyFor(value = CountryEntity.class, locator = CountryLocator.class)
public interface CountryProxy extends EntityProxy {

    String getCode();

    void setCode(String code);

    String getLibelle();

    void setLibelle(String libelle);
}
