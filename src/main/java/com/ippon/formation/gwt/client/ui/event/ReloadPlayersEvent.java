package com.ippon.formation.gwt.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;

public class ReloadPlayersEvent extends GwtEvent<ReloadPlayerHandler> {

    public static final Type<ReloadPlayerHandler> TYPE = new Type<ReloadPlayerHandler>();

    @Override
    public Type<ReloadPlayerHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ReloadPlayerHandler handler) {
        handler.onReloadPlayers(this);
    }

}
