package org.cnam.cloud.wsrest.model;

import org.cnam.cloud.wsrest.model.Livreurs;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface LivreurServiceInterface {

	@Put
	 void create(Livreurs livreur);
	
	 @Get
	 ContainerLivreurs connexionLivreur();
}
