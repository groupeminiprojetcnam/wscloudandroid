package org.cnam.cloud.wsrest.model;


import org.restlet.resource.Put;

public interface ClientsOrganisationsInterface {
	@Put
	void create(ClientsOrganisations clientsOrganisations);
}
