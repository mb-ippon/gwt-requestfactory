package com.ippon.formation.gwt.client.ui.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.CountryProxy;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.PlayerProxy;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.widget.ListCountry;
import com.ippon.formation.gwt.client.ui.widget.PlaysHanded;
import com.ippon.formation.gwt.client.ui.widget.YearBox;

public class PlayerViewImpl extends Composite implements PlayerView, Editor<PlayerProxy> {

    private static PlayerViewImplUiBinder uiBinder = GWT.create(PlayerViewImplUiBinder.class);

    private Presenter activity;

    interface PlayerViewImplUiBinder extends UiBinder<Widget, PlayerViewImpl> {
    }

    @UiField
    @Path("name")
    TextBox name;

    @UiField
    @Ignore
    Element lblName;

    @UiField
    @Ignore
    Element lblHeight;

    @UiField
    @Ignore
    Element lblWeight;

    @UiField
    @Ignore
    Element lblBirthday;

    @UiField
    @Ignore
    Element lblTurnPro;

    @UiField
    @Ignore
    Element lblCountry;

    @UiField
    @Ignore
    Element lblAtpPoint;

    @UiField
    @Path("birthDay")
    DateBox birthDay;

    @UiField
    @Path("country")
    ListCountry country;

    @UiField
    @Path("height")
    IntegerBox height;

    @UiField
    @Path("weight")
    IntegerBox weight;

    @UiField
    @Path("atpPoint")
    IntegerBox atpPoint;

    @UiField
    @Path("yearTurnPro")
    YearBox yearTurnPro;

    @UiField
    Button updatePlayer;

    @UiField
    @Path("playHand")
    PlaysHanded plays;

    @Override
    public void setButtonEnabled(boolean b) {
        updatePlayer.setEnabled(b);
        if (b) {
            updatePlayer.removeStyleName("disabled");
        }
        else {
            updatePlayer.addStyleName("disabled");
        }
    }

    @UiHandler("updatePlayer")
    void onUpdatePlayer(ClickEvent e) {
        activity.updatePlayer();
    }

    @Override
    public void setPresenter(Presenter playersActivity) {
        this.activity = playersActivity;
    }

    public PlayerViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        lblName.setInnerText(ApplicationResources.getMessages().player_name());
        lblBirthday.setInnerText(ApplicationResources.getMessages().player_birthday());
        lblCountry.setInnerText(ApplicationResources.getMessages().player_country());
        lblHeight.setInnerText(ApplicationResources.getMessages().player_height());
        lblTurnPro.setInnerText(ApplicationResources.getMessages().player_turnedpro());
        lblWeight.setInnerText(ApplicationResources.getMessages().player_weight());
        lblAtpPoint.setInnerText(ApplicationResources.getMessages().player_point());
        birthDay.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd MMMM yyyy")));
    }

    @Override
    public void setDataCountry(List<CountryProxy> response) {
        country.setData(response);
    }
}
