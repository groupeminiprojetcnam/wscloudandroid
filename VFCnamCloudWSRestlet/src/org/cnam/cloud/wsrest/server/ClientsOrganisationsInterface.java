package org.cnam.cloud.wsrest.server;

import org.cnam.cloud.wsrest.model.ClientsOrganisations;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface ClientsOrganisationsInterface {
	@Put
	void create(ClientsOrganisations clientsOrganisations);
	
	
	
	 @Get
	 ContainerClientsOrganisations verifierAssociationClientOrganisations();
	
}
