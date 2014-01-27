package com.ippon.formation.gwt.client.domain.bindery.rf.request;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.PlayerProxy;
import com.ippon.formation.gwt.server.service.AppServicesLocator;
import com.ippon.formation.gwt.server.service.PlayerServiceImpl;

@Service(value = PlayerServiceImpl.class, locator = AppServicesLocator.class)
public interface PlayerRequest extends RequestContext {

    Request<PlayerProxy> findPlayer(String name);

    Request<Void> addPlayer(PlayerProxy player);

    Request<Void> updatePlayer(PlayerProxy player);

}
