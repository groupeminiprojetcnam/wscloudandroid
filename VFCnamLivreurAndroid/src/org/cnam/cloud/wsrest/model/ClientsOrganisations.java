package org.cnam.cloud.wsrest.model;

import java.io.Serializable;


public class ClientsOrganisations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8813439596043993221L;
	
	private Long idClientOrganisation; 
	private Long idClient; 
	private Long idOrganisation;
	
	
	public ClientsOrganisations() {}
	
	public Long getIdClientOrganisation() {
		return idClientOrganisation;
	}
	public void setIdClientOrganisation(Long idClientOrganisation) {
		this.idClientOrganisation = idClientOrganisation;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Long getIdOrganisation() {
		return idOrganisation;
	}
	public void setIdOrganisation(Long idOrganisation) {
		this.idOrganisation = idOrganisation;
	} 

}
