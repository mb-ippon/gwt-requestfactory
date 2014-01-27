package com.ippon.formation.gwt.client.ui.activity;

import com.ippon.formation.gwt.client.ui.event.AddPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.AddPlayerHandler;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerHandler;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.view.PlayerView;
import com.ippon.formation.gwt.client.ui.view.PlayerView.Presenter;
import com.ippon.formation.gwt.shared.domain.entities.Player;

/**
 * Activity du l'écran détaillé d'un joueur
 * 
 * @author mbellang
 * 
 */
public class PlayerActivity implements Presenter {

    private final PlayerView display;

    public PlayerActivity(PlayerView display) {
        this.display = display;
        this.display.setPresenter(this);
        bind();
    }

    private boolean isUpdate;

    /**
     * Affiche le détail d'un joueur
     * 
     * @param player
     */
    protected void displayPlayer(Player player) {
        if (player != null) {
            isUpdate = false;

        }
    }

    /**
     * Ajoute un nouveau joueur
     * 
     */
    protected void addPlayer() {
        isUpdate = false;
        display.setButtonEnabled(true);
    }

    @Override
    public void updatePlayer() {
        if (isUpdate) {

        }
        else {

        }
    }

    private void bind() {

        display.setButtonEnabled(false);

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
