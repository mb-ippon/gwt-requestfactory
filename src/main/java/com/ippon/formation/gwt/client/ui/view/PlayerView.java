package com.ippon.formation.gwt.client.ui.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.CountryProxy;

public interface PlayerView extends IsWidget {

    public interface Presenter {

        void updatePlayer();

    }

    void setPresenter(Presenter playersActivity);

    void setButtonEnabled(boolean b);

    void setDataCountry(List<CountryProxy> response);
}
