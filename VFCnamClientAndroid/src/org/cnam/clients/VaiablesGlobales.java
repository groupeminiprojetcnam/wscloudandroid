package org.cnam.clients;

import java.util.ArrayList;

import org.cnam.cloud.wsrest.model.Clients;
import org.cnam.cloud.wsrest.model.TemplateDemandeLivreur;

import android.app.Application;

public class VaiablesGlobales extends Application{
     private Clients clients;
     private TemplateDemandeLivreur templateDemandeLivreur; 
     private ArrayList<Long> listOrganisation = new ArrayList<Long>(); 

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public TemplateDemandeLivreur getTemplateDemandeLivreur() {
		return templateDemandeLivreur;
	}

	public void setTemplateDemandeLivreur(
			TemplateDemandeLivreur templateDemandeLivreur) {
		this.templateDemandeLivreur = templateDemandeLivreur;
	}

	public ArrayList<Long> getListOrganisation() {
		return listOrganisation;
	}

	public void setListOrganisation(ArrayList<Long> listOrganisation) {
		this.listOrganisation = listOrganisation;
	}   
}
