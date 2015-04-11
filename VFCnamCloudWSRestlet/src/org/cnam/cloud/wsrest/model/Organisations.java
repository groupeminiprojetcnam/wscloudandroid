package org.cnam.cloud.wsrest.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Organisations  implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 796136633599077357L;
	@Id
	 private Long idOrganisation;
	 private String libelleOrganisation; 
	 private String descriptionOrganisation;
	 
	 public Organisations() {}
	 
	public Long getIdOrganisation() {
		return idOrganisation;
	}
	public void setIdOrganisation(Long idOrganisation) {
		this.idOrganisation = idOrganisation;
	}
	public String getLibelleOrganisation() {
		return libelleOrganisation;
	}
	public void setLibelleOrganisation(String libelleOrganisation) {
		this.libelleOrganisation = libelleOrganisation;
	}
	public String getDescriptionOrganisation() {
		return descriptionOrganisation;
	}
	public void setDescriptionOrganisation(String descriptionOrganisation) {
		this.descriptionOrganisation = descriptionOrganisation;
	} 
}
