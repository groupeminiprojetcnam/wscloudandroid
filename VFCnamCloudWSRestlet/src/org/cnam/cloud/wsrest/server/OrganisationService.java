package org.cnam.cloud.wsrest.server;

import java.util.ArrayList;
import java.util.List;

import org.cnam.cloud.wsrest.model.Clients;
import org.cnam.cloud.wsrest.model.Livreurs;
import org.cnam.cloud.wsrest.model.Organisations;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class OrganisationService  extends ServerResource implements OrganisationServiceInterface {

	@Override
	public void create(Organisations organisations) {
		// TODO Auto-generated method stub
		
		 ObjectifyService.register(Organisations.class);
		 Objectify ofy = ObjectifyService.begin();
		 Organisations org = new Organisations(); 
		 org.setLibelleOrganisation(organisations.getLibelleOrganisation()); 
		 org.setDescriptionOrganisation(organisations.getDescriptionOrganisation()); 
		 ofy.put(org); 
	}

	@Override
	@Get
	public ContainerOrganisations getAllOrganisations() {
		ContainerOrganisations content = null;
		 List organisations = new ArrayList();
		 ObjectifyService.register(Organisations.class);
		 Objectify ofy = ObjectifyService.begin();
		 
		 

		 Query<Organisations> orfanisationss = ofy.query(Organisations.class);
		for (Organisations org : orfanisationss)
			organisations.add(org);


		 content = new ContainerOrganisations();
		 content.setOrganisation_list(organisations);

		 return content;
	}
}
