package com.ippon.formation.gwt.client.ui.activity;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ippon.formation.gwt.client.domain.bindery.rpc.PlayerRPCAsync;
import com.ippon.formation.gwt.client.ui.event.AddPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.ReloadPlayerHandler;
import com.ippon.formation.gwt.client.ui.event.ReloadPlayersEvent;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.view.PlayersView;
import com.ippon.formation.gwt.shared.domain.entities.Player;

/**
 * L'activity de la grid des joueurs
 * 
 * @author mbellang
 * 
 */
public class PlayersActivity implements PlayersView.Presenter {

    private final PlayersView display;

    private final PlayerRPCAsync server = PlayerRPCAsync.Util.getInstance();

    public PlayersActivity(PlayersView display) {
        this.display = display;
        this.display.setPresenter(this);
        bind();
    }

    /**
     * lance l'affichage du tableau
     * 
     */
    public void go() {
        reloadPlayers();
    }

    private void reloadPlayers() {
        display.loadingTable();
        server.findClassement(new AsyncCallback<List<Player>>() {

            @Override
            public void onSuccess(List<Player> result) {
                display.setData(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }
        });
    }

    @Override
    public void onCellTableSelected(Player player) {
        ApplicationResources.getHandlerManager().fireEvent(new DisplayPlayerEvent(player));
    }

    @Override
    public void onAddPlayer() {
        display.unSelectedTable();
        ApplicationResources.getHandlerManager().fireEvent(new AddPlayerEvent());
    }

    private void bind() {

        ApplicationResources.getHandlerManager().addHandler(ReloadPlayersEvent.TYPE, new ReloadPlayerHandler() {

            @Override
            public void onReloadPlayers(ReloadPlayersEvent event) {
                reloadPlayers();
            }
        });
    }
}
