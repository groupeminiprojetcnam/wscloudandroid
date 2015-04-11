package org.cnam.cloud.wsrest.model;

import java.util.ArrayList;
import java.util.List;

public class ContainerClientsOrganisations {

	public List<ClientsOrganisations> clientsOrganisations_list;

	public List<ClientsOrganisations> getClientsOrganisations_list() {
		return clientsOrganisations_list;
	}

	public void setClientsOrganisations_list(List<ClientsOrganisations> clientsOrganisations_list) {
		this.clientsOrganisations_list = clientsOrganisations_list;
	} 
	
	
	public ContainerClientsOrganisations()
	 {
		clientsOrganisations_list = new ArrayList<ClientsOrganisations>();
	 }

	 public ContainerClientsOrganisations(List<ClientsOrganisations> clientsOrganisations_list)
	 {
	 this.clientsOrganisations_list = clientsOrganisations_list;
	 }
	
	
}
