package com.ippon.formation.gwt.client.domain.bindery.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.ippon.formation.gwt.shared.domain.entities.Player;

@RemoteServiceRelativePath("player")
public interface PlayerRPC extends RemoteService {

    List<Player> findClassement();
}
