package org.cnam.cloud.wsrest.server;

import java.util.ArrayList;
import java.util.List;

public class ContainerOrganisations {

	public List organisation_list;

	public List getOrganisation_list() {
		return organisation_list;
	}

	public void setOrganisation_list(List organisation_list) {
		this.organisation_list = organisation_list;
	} 
	
	
	public ContainerOrganisations()
	 {
		organisation_list = new ArrayList();
	 }

	 public ContainerOrganisations(List organisation_list)
	 {
	 this.organisation_list = organisation_list;
	 }
	
}
