package org.cnam.clients;


import java.util.ArrayList;

import org.cnam.cloud.wsrest.model.ClientService;
import org.cnam.cloud.wsrest.model.Clients;
import org.cnam.cloud.wsrest.model.ClientsOrganisations;
import org.cnam.cloud.wsrest.model.ClientsOrganisationsService;
import org.cnam.cloud.wsrest.model.ContainerClients;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AjouterClientActivity extends Activity {

	
	   public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.ajouter_client);
			
			
			/*
	    	 * list des organisation client
	    	 */
			
			Button btnListOrg = (Button) findViewById(R.id.ajouter_list_organisation);
			btnListOrg.setOnClickListener(new OnClickListener() {

			    @Override
			    public void onClick(View v) {
			    	  Intent ii = new Intent(AjouterClientActivity.this, ListOrganisationActivity.class);
    			      startActivityForResult(ii, 1); 		
			    }
			});
		    
			
			
			
			

			Button btn = (Button) findViewById(R.id.ajouter_client);
			btn.setOnClickListener(new OnClickListener() {

			    @Override
			    public void onClick(View v) {
			    	ajouterClient();			
			    }
			});
		    }
	   
	    final void ajouterClient()
	    {
		final Thread checkUpdate = new Thread() {
		    public void run() {
		    	
		    	/*
		    	 * Recuperer la list des organisation
		    	 */
		    	VaiablesGlobales vg = (VaiablesGlobales)getApplication();
		    	ArrayList<Long> listOrg = vg.getListOrganisation(); 
		    	for(Long l : listOrg){
		    		Log.e("  ID LONG ",""+l);
		    	}
		    	
		    	 /*
		    	  * Recuperer tous les champs     
		    	  */
		    	EditText nomCient	 = (EditText) findViewById(R.id.nomCient);
		    	EditText prenomClient = (EditText) findViewById(R.id.prenomClient);
		    	EditText mailClient = (EditText) findViewById(R.id.mailClient);
		    	EditText loginClient = (EditText) findViewById(R.id.loginClient);
		    	EditText motPasseClient = (EditText) findViewById(R.id.motPasseClient);
		    	EditText idTelephoneClient = (EditText) findViewById(R.id.idTelephoneClient);
		    	EditText adresse = (EditText) findViewById(R.id.adresse);
		    	EditText complementAdresse = (EditText) findViewById(R.id.complementAdresse);
		    	
		    	EditText codePostal = (EditText) findViewById(R.id.codePostal);
		    	EditText ville = (EditText) findViewById(R.id.ville);
		    	EditText numeroBal = (EditText) findViewById(R.id.numeroBal);
		    	
		    	
		    
		    
		    	
		    	
		    	
		    	Clients c = new Clients(); 
		    	
		    	c.setNomClient(nomCient.getText().toString());
		    	c.setPrenomClient(prenomClient.getText().toString());
		    	c.setMailClient(mailClient.getText().toString());
		    	c.setLoginClient(loginClient.getText().toString());
		    	c.setMotPasseClient(motPasseClient.getText().toString());
		    	c.setIdTelephoneClient(idTelephoneClient.getText().toString());
		    	c.setAdresse(adresse.getText().toString());
		    	c.setCodePostal(codePostal.getText().toString());
		    	c.setComplementAdresse(complementAdresse.getText().toString());
		    	c.setVille(ville.getText().toString());
		    	c.setNumeroBal(numeroBal.getText().toString());
		   
		    	final ClientService uc = new ClientService();
		    	final ClientsOrganisationsService coc = new ClientsOrganisationsService(); 
				try {
				    uc.create(c);
				    ContainerClients clientCree=  uc.connexionClient(mailClient.getText().toString(), motPasseClient.getText().toString());
				    Log.e("Client Cree :", "  "+clientCree.clients_list.get(0).getIdClient()); 
					for(Long l : listOrg){
						ClientsOrganisations co = new ClientsOrganisations(); 
						co.setIdClient(clientCree.clients_list.get(0).getIdClient());
						co.setIdOrganisation(l); 
						coc.create(co); 
			    		Log.e(" Organisation  en registree ID LONG ",""+l);
			    	}
				} catch (Exception e) {
					e.printStackTrace();
				    return;
				}
				
				
				final Intent intent = new Intent(AjouterClientActivity.this,
						ClientAccueilActivity.class);
				startActivity(intent);
			    }
		    
			};
			checkUpdate.start();
		    }
	   
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	    	MenuInflater inflater = getMenuInflater();
	    	inflater.inflate(R.menu.fragment_menu_icons_bouton_retour_board, menu);
	    	return true;
	    }
	    
}
