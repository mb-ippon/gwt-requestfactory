package com.ippon.formation.gwt.client.ui.widget;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.ListBox;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.CountryProxy;

public class ListCountry extends ListBox implements LeafValueEditor<CountryProxy> {

    private final List<CountryProxy> data = Lists.newArrayList();

    public void setData(List<CountryProxy> data) {
        this.data.clear();
        this.data.addAll(data);
        for (CountryProxy c : data) {
            if (c != null) {
                this.addItem(c.getLibelle());
            }
        }

    }

    @Override
    public void setValue(CountryProxy value) {
        for (int index = 0; index < data.size(); index++) {
            CountryProxy c = data.get(index);
            if (c != null && value != null && c.getLibelle().equals(value.getLibelle())) {
                this.setSelectedIndex(index);
                break;
            }
        }
    }

    @Override
    public CountryProxy getValue() {
        return data.get(this.getSelectedIndex());
    }

}
