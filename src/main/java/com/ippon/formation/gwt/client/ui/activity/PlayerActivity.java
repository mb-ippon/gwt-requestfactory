package com.ippon.formation.gwt.client.ui.activity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.ippon.formation.gwt.client.ui.event.AddPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.AddPlayerHandler;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerHandler;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.view.PlayerView;
import com.ippon.formation.gwt.client.ui.view.PlayerView.Presenter;
import com.ippon.formation.gwt.client.ui.view.PlayerViewImpl;
import com.ippon.formation.gwt.shared.domain.entities.Player;

/**
 * Activity du l'écran détaillé d'un joueur
 * 
 * @author mbellang
 * 
 */
public class PlayerActivity implements Presenter {

    private final PlayerView display;
    private final PlayerDriver playerDriver = PlayerDriver.Util.getInstance();

    public PlayerActivity(PlayerView display) {
        this.display = display;
        this.display.setPresenter(this);
        bind();
    }

    /**
     * Driver data binding
     * 
     * @author mbellang
     * 
     */
    public interface PlayerDriver extends SimpleBeanEditorDriver<Player, PlayerViewImpl> {

        public class Util {

            private static PlayerDriver instance;

            public static PlayerDriver getInstance() {
                if (instance == null) {
                    instance = GWT.create(PlayerDriver.class);
                }
                return instance;
            }
        }
    }

    /**
     * Affiche le détail d'un joueur
     * 
     * @param player
     */
    protected void displayPlayer(Player player) {
        // TODO display a player
    }

    /**
     * Ajoute un nouveau joueur
     * 
     */
    protected void addPlayer() {
        // TODO add a player
    }

    @Override
    public void updatePlayer() {
        // TODO update a player

    }

    private void bind() {
        playerDriver.initialize((PlayerViewImpl) display);

        ApplicationResources.getHandlerManager().addHandler(DisplayPlayerEvent.TYPE, new DisplayPlayerHandler() {

            @Override
            public void onDisplayPlayer(DisplayPlayerEvent event) {
                displayPlayer(event.getPlayer());
            }
        });

        ApplicationResources.getHandlerManager().addHandler(AddPlayerEvent.TYPE, new AddPlayerHandler() {

            @Override
            public void onAddPlayer(AddPlayerEvent event) {
                addPlayer();
            }
        });
    }

}
