package org.cnam.cloud.wsrest.model;

import java.util.List;

import org.restlet.resource.ClientResource;

import android.util.Log;

public class OrgnaisationService {

	
	  public final ClientResource cr = new ClientResource(
			    EngineConfiguration.gae_path + "/rest/organisation");

		    public OrgnaisationService() {
			     EngineConfiguration.getInstance();
		    }
		
		    
		   public  void create(Organisations organisations) throws Exception {
			   final OrganisationServiceInterface uci = cr.wrap(OrganisationServiceInterface.class); 
			   	try {
		    	    uci.create(organisations);
		    	    Log.i("OrgnaisationService ", "Creation success !");
		    	} catch (Exception e) {
		    	    Log.i("OrgnaisationService", "Creation failed !");
		    	    e.printStackTrace();
		    	    throw e;
		    	}
		   }
		   
		    public List<Organisations> getAllOrganisations() {
		    	final OrganisationServiceInterface uci = cr
		    		.wrap(OrganisationServiceInterface.class);
		    	ContainerOrganisations content = uci.getAllOrganisations();
		    	return content.getOrganisation_list();
		        }
		    
}
