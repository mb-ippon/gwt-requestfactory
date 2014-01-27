package com.ippon.formation.gwt.server.service;

import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;

public interface PlayerService {

    PlayerEntity findPlayer(String name);

    PlayerEntity findPlayer(Long id);

    void addPlayer(PlayerEntity player);

    void updatePlayer(PlayerEntity player);
}
