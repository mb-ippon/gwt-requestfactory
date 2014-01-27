package com.ippon.formation.gwt.client.ui.widget;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gwt.user.client.ui.ListBox;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.CountryProxy;

public class ListCountry extends ListBox {

    private final List<CountryProxy> data = Lists.newArrayList();

    public void setData(List<?> data) {
        this.data.clear();

    }
}
