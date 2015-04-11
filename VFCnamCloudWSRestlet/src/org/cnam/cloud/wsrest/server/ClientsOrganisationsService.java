package org.cnam.cloud.wsrest.server;

import java.util.ArrayList;
import java.util.List;

import org.cnam.cloud.wsrest.model.ClientsOrganisations;
import org.restlet.data.Form;
import org.restlet.resource.ServerResource;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class ClientsOrganisationsService extends ServerResource implements ClientsOrganisationsInterface {

	@Override
	public void create(ClientsOrganisations clientsOrganisations) {
		 ObjectifyService.register(ClientsOrganisations.class);
		 Objectify ofy = ObjectifyService.begin();

		 ClientsOrganisations clientOrg = new ClientsOrganisations();
         clientOrg.setIdClient(clientsOrganisations.getIdClient()); 
         clientOrg.setIdOrganisation(clientsOrganisations.getIdOrganisation()); 
		 try {
		     ofy.put(clientOrg);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		
	}

	@Override
	public
	ContainerClientsOrganisations verifierAssociationClientOrganisations() {

		Form queryParams = getReference().getQueryAsForm();
		 String idClient = queryParams.getFirstValue("idClient");
		 String idOrganisation = queryParams.getFirstValue("idOrganisation");
		 ContainerClientsOrganisations content = null;
		 List<ClientsOrganisations> clientOrganisation = new ArrayList<ClientsOrganisations>();
		 ObjectifyService.register(ClientsOrganisations.class);
		 Objectify ofy = ObjectifyService.begin();
		 Query<ClientsOrganisations> q = ofy.query(ClientsOrganisations.class);
		for (ClientsOrganisations co : q) {
			 if((co.getIdClient().equals(Long.parseLong(idClient))) && (co.getIdOrganisation().equals(Long.parseLong(idOrganisation)))) 
				 clientOrganisation.add(co);
		}
		 content = new ContainerClientsOrganisations();
		 content.setClientsOrganisations_list(clientOrganisation);
		 return content;
	}

	
}
