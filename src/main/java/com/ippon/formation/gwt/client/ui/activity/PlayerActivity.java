package com.ippon.formation.gwt.client.ui.activity;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.CountryProxy;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.PlayerProxy;
import com.ippon.formation.gwt.client.domain.bindery.rf.request.CountryRequest;
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
    public interface PlayerDriver extends RequestFactoryEditorDriver<PlayerProxy, PlayerViewImpl> {

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

    PlayerProxy playerProxy;
    private boolean isUpdate;

    /**
     * Affiche le détail d'un joueur
     * 
     * @param player
     */
    protected void displayPlayer(Player player) {
        if (player != null) {
            isUpdate = true;
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
        if (playerDriver.isDirty()) {
            playerDriver.flush();
            if (isUpdate) {

            }
            else {

            }

        }
    }

    private void bind() {

        playerDriver.initialize((PlayerViewImpl) display);

        CountryRequest request = ApplicationResources.getRequestFactory().countryRequest();
        request.findCountries().fire(new Receiver<List<CountryProxy>>() {

            @Override
            public void onSuccess(List<CountryProxy> response) {
                display.setDataCountry(response);
            }
        });

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
