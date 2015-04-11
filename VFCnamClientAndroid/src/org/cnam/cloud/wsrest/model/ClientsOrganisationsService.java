package org.cnam.cloud.wsrest.model;

import org.restlet.resource.ClientResource;

import android.util.Log;

public class ClientsOrganisationsService {

	

    public final ClientResource cr = new ClientResource(
    	    EngineConfiguration.gae_path + "/rest/clientsorganisations");
    
    public ClientsOrganisationsService(){
    	EngineConfiguration.getInstance();
    }
    
    
    
    public void create(ClientsOrganisations clientsOrganisations) throws Exception {
	final ClientsOrganisationsInterface uci = cr
		.wrap(ClientsOrganisationsInterface.class);

	try {
	    uci.create(clientsOrganisations);
	    Log.i("clientsOrganisations", "Creation success !");
	} catch (Exception e) {
	    Log.i("clientsOrganisations", "Creation failed !");
	    e.printStackTrace();
	    throw e;
	}
    }
	
}
