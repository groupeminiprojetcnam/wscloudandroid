package org.cnam.cloud.wsrest.model;

import java.util.List;

import org.restlet.resource.ClientResource;

public class OrganisationService {

	  public final ClientResource cr = new ClientResource(
			    EngineConfiguration.gae_path + "/rest/organisation");

		    public OrganisationService() {
			     EngineConfiguration.getInstance();
		    }
		    
		    
		    public List<Organisations> getAllOrganisations() {
		    	final OrganisationServiceInterface uci = cr
		    		.wrap(OrganisationServiceInterface.class);
		    	ContainerOrganisations content = uci.getAllOrganisations();
		    	return content.getOrganisation_list();
		        }
	
}
