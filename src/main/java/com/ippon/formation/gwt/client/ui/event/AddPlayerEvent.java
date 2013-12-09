package com.ippon.formation.gwt.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddPlayerEvent extends GwtEvent<AddPlayerHandler> {

    public static final Type<AddPlayerHandler> TYPE = new Type<AddPlayerHandler>();

    @Override
    public Type<AddPlayerHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddPlayerHandler handler) {
        handler.onAddPlayer(this);
    }

}
