package org.cnam.cloud.wsrest.server;

import java.util.ArrayList;
import java.util.List;

public class ContainerClientsOrganisations {

	public List clientsOrganisations_list;

	public List getClientsOrganisations_list() {
		return clientsOrganisations_list;
	}

	public void setClientsOrganisations_list(List clientsOrganisations_list) {
		this.clientsOrganisations_list = clientsOrganisations_list;
	} 
	
	
	public ContainerClientsOrganisations()
	 {
		clientsOrganisations_list = new ArrayList();
	 }

	 public ContainerClientsOrganisations(List clientsOrganisations_list)
	 {
	 this.clientsOrganisations_list = clientsOrganisations_list;
	 }
	
	
}
