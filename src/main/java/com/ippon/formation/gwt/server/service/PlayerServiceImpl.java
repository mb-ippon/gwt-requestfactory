package com.ippon.formation.gwt.server.service;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ippon.formation.gwt.client.domain.bindery.rpc.PlayerRPC;
import com.ippon.formation.gwt.server.domain.dao.PlayerDao;
import com.ippon.formation.gwt.server.domain.dao.PlayerDaoImpl;
import com.ippon.formation.gwt.server.domain.entities.PlayerEntity;
import com.ippon.formation.gwt.shared.domain.entities.Country;
import com.ippon.formation.gwt.shared.domain.entities.Player;

public class PlayerServiceImpl extends RemoteServiceServlet implements PlayerService, PlayerRPC {

    /**
     * 
     */
    private static final long serialVersionUID = -2548629217488353905L;

    private final PlayerDao dao = new PlayerDaoImpl();

    @Override
    public List<Player> findClassement() {
        List<PlayerEntity> playerEntities = dao.findClassement();
        List<Player> players = Lists.newArrayList();
        for (PlayerEntity input : playerEntities) {
            Country country = new Country(input.getCountry().getCode(), input.getCountry().getLibelle());
            players.add(new Player(input.getName(), input.getHeight(), input.getWeight(), input.getBirthDay(), input
                    .getPlayHand(), input.getYearTurnPro(), input.getAtpPoint(), country));
        }
        return players;
    }

    @Override
    public PlayerEntity findPlayer(String name) {
        return dao.findPlayer(name);
    }
}
