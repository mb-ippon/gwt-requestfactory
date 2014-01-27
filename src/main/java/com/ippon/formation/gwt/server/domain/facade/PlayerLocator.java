package com.ippon.formation.gwt.server.domain.facade;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.server.service.PlayerService;
import com.ippon.formation.gwt.server.service.PlayerServiceImpl;

public class PlayerLocator extends Locator<PlayerEntity, Long> {

    PlayerService service = new PlayerServiceImpl();

    @Override
    public PlayerEntity create(Class<? extends PlayerEntity> clazz) {
        return new PlayerEntity();
    }

    @Override
    public PlayerEntity find(Class<? extends PlayerEntity> clazz, Long id) {
        return service.findPlayer(id);
    }

    @Override
    public Class<PlayerEntity> getDomainType() {
        return PlayerEntity.class;
    }

    @Override
    public Long getId(PlayerEntity domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(PlayerEntity domainObject) {
        return domainObject.getVersion();
    }

}
