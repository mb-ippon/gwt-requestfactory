package com.ippon.formation.gwt.client.ui.activity;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.validation.client.impl.Validation;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.CountryProxy;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.PlayerProxy;
import com.ippon.formation.gwt.client.domain.bindery.rf.request.CountryRequest;
import com.ippon.formation.gwt.client.domain.bindery.rf.request.PlayerRequest;
import com.ippon.formation.gwt.client.ui.event.AddPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.AddPlayerHandler;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerHandler;
import com.ippon.formation.gwt.client.ui.event.ReloadPlayersEvent;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.view.PlayerView;
import com.ippon.formation.gwt.client.ui.view.PlayerView.Presenter;
import com.ippon.formation.gwt.client.ui.view.PlayerViewImpl;
import com.ippon.formation.gwt.shared.domain.entities.Player;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

/**
 * Activity du l'écran détaillé d'un joueur
 * 
 * @author mbellang
 * 
 */
public class PlayerActivity implements Presenter {

    private final PlayerView display;
    private final PlayerDriver playerDriver = PlayerDriver.Util.getInstance();
    private PlayerRequest request;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

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
            display.setButtonEnabled(true);

            request = ApplicationResources.getRequestFactory().playerRequest();
            request.findPlayer(player.getName()).with("country").fire(new Receiver<PlayerProxy>() {

                @Override
                public void onSuccess(PlayerProxy response) {
                    request = ApplicationResources.getRequestFactory().playerRequest();
                    playerProxy = request.edit(response);
                    playerDriver.edit(playerProxy, request);
                }
            });
        }
    }

    /**
     * Ajoute un nouveau joueur
     * 
     */
    protected void addPlayer() {
        isUpdate = false;
        display.setButtonEnabled(true);
        request = ApplicationResources.getRequestFactory().playerRequest();
        playerProxy = request.create(PlayerProxy.class);
        playerProxy.setPlayHand(Plays.RightHanded);
        playerDriver.edit(playerProxy, request);
    }

    @Override
    public void updatePlayer() {
        if (playerDriver.isDirty()) {
            playerDriver.flush();
            Set<ConstraintViolation<PlayerProxy>> violations = validator.validate(playerProxy);
            if (violations.isEmpty()) {
                if (isUpdate) {
                    request.updatePlayer(playerProxy).fire(new Receiver<Void>() {

                        @Override
                        public void onSuccess(Void response) {
                            Window.alert("ok !");
                            request = ApplicationResources.getRequestFactory().playerRequest();
                            playerProxy = request.edit(playerProxy);
                            playerDriver.edit(playerProxy, request);
                        }
                    });
                }
                else {
                    request.addPlayer(playerProxy).fire(new Receiver<Void>() {

                        @Override
                        public void onSuccess(Void response) {
                            Window.alert("ok !");
                            request = ApplicationResources.getRequestFactory().playerRequest();
                            playerProxy = request.edit(playerProxy);
                            playerDriver.edit(playerProxy, request);
                        }
                    });
                }
                ApplicationResources.getHandlerManager().fireEvent(new ReloadPlayersEvent());
            }
            else {
                Window.alert("error : " + violations.toString());
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
