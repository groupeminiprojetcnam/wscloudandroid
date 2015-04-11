package org.cnam.cloud.wsrest.model;

import java.util.ArrayList;
import java.util.List;

public class ContainerOrganisations {

	public List<Organisations> organisation_list;

	public List<Organisations> getOrganisation_list() {
		return organisation_list;
	}

	public void setOrganisation_list(List<Organisations> organisation_list) {
		this.organisation_list = organisation_list;
	} 
	
	
	public ContainerOrganisations()
	 {
		organisation_list = new ArrayList<Organisations>();
	 }

	 public ContainerOrganisations(List<Organisations> organisation_list)
	 {
	 this.organisation_list = organisation_list;
	 }
	
}
