package com.ippon.formation.gwt.server.service;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class AppServicesLocator implements ServiceLocator {

    @Override
    public Object getInstance(Class<?> clazz) {
        try {
            return clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
