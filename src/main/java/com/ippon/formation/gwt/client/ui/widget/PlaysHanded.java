package com.ippon.formation.gwt.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

public class PlaysHanded extends Composite implements LeafValueEditor<Plays> {

    private static PlaysHandedUiBinder uiBinder = GWT.create(PlaysHandedUiBinder.class);

    interface PlaysHandedUiBinder extends UiBinder<Widget, PlaysHanded> {
    }

    public PlaysHanded() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    RadioButton playsRight;

    @UiField
    RadioButton playsLeft;

    @Override
    public void setValue(Plays value) {
        switch (value) {
        case LeftHanded:
            playsLeft.setValue(true);
            break;
        default:
            playsRight.setValue(true);
            break;
        }
    }

    @Override
    public Plays getValue() {
        Plays plays;
        if (playsRight.getValue()) {
            plays = Plays.RightHanded;
        }
        else {
            plays = Plays.LeftHanded;
        }
        return plays;
    }
}
