package org.cnam.cloud.wsrest.model;

import org.cnam.cloud.wsrest.model.Organisations;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface OrganisationServiceInterface {

	@Put
	 void create(Organisations organisations);
	
	@Get
	public ContainerOrganisations getAllOrganisations(); 
	
	
	
}
