package com.ippon.formation.gwt.server.domain.dao;

import java.util.List;

import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;

public interface PlayerDao {

    List<PlayerEntity> findClassement();

    PlayerEntity findPlayer(String name);

    PlayerEntity findPlayer(Long id);

    void addPlayer(PlayerEntity player);

    void updatePlayer(PlayerEntity player);
}
