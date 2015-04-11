package org.cnam.cloud.wsrest.model;

import org.restlet.resource.ClientResource;

public class ClientsOrganisationsService {

	
	  public final ClientResource cr = new ClientResource(
			    EngineConfiguration.gae_path + "/rest/clientsorganisations");

		    public ClientsOrganisationsService() {
			     EngineConfiguration.getInstance();
		    }
		    
		
			public ContainerClientsOrganisations verifierAssociationClientOrganisations(String idClient , String idOrganisation) {
			 	final ClientsOrganisationsInterface uci = cr
			    		.wrap(ClientsOrganisationsInterface.class);
				cr.getReference().addQueryParameter("idClient", idClient);
				cr.getReference().addQueryParameter("idOrganisation", idOrganisation);
				ContainerClientsOrganisations content = uci.verifierAssociationClientOrganisations();
				return content;  
			}
    
}
