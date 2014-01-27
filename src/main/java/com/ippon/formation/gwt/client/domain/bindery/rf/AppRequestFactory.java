package com.ippon.formation.gwt.client.domain.bindery.rf;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.ippon.formation.gwt.client.domain.bindery.rf.request.CountryRequest;
import com.ippon.formation.gwt.client.domain.bindery.rf.request.PlayerRequest;

public interface AppRequestFactory extends RequestFactory {

    PlayerRequest playerRequest();

    CountryRequest countryRequest();

    public class Util {

        private static AppRequestFactory instance;

        public static AppRequestFactory getInstance() {
            if (instance == null) {
                instance = GWT.create(AppRequestFactory.class);
            }
            return instance;
        }
    }

}
