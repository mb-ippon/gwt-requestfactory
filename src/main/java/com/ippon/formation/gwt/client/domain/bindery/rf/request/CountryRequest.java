package com.ippon.formation.gwt.client.domain.bindery.rf.request;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.CountryProxy;
import com.ippon.formation.gwt.server.service.AppServicesLocator;
import com.ippon.formation.gwt.server.service.CountryServiceImpl;

@Service(value = CountryServiceImpl.class, locator = AppServicesLocator.class)
public interface CountryRequest extends RequestContext {

    Request<List<CountryProxy>> findCountries();
}
