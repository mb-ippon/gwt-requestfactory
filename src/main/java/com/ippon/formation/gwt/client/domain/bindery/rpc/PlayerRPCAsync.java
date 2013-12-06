package com.ippon.formation.gwt.client.domain.bindery.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface PlayerRPCAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.ippon.formation.gwt.client.domain.bindery.rpc.PlayerRPC
     */
    void findClassement( AsyncCallback<java.util.List<com.ippon.formation.gwt.shared.domain.entities.Player>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static PlayerRPCAsync instance;

        public static final PlayerRPCAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (PlayerRPCAsync) GWT.create( PlayerRPC.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
