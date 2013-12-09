package com.ippon.formation.gwt.server.service;

import java.util.List;

import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.shared.domain.entities.Player;

public interface PlayerService {

    List<Player> findClassement();

    PlayerEntity findPlayer(String name);

    void addPlayer(PlayerEntity player);

    void updatePlayer(PlayerEntity player);
}
