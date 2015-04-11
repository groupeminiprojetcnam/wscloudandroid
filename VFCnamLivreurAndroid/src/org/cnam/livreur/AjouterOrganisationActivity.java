package org.cnam.livreur;

import org.cnam.cloud.wsrest.model.Organisations;
import org.cnam.cloud.wsrest.model.OrgnaisationService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterOrganisationActivity extends Activity {

	
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.ajouter_organisation);

	Button btn = (Button) findViewById(R.id.ajouterOrganisation);
	btn.setOnClickListener(new OnClickListener() {

	    @Override
	    public void onClick(View v) {
	    	ajouterOrganisation();			
	    }
	});
    }
    
    
    final void ajouterOrganisation()
    {
		EditText titreOrg = (EditText) findViewById(R.id.libelleOrganisation);
		EditText descriptionOrg = (EditText) findViewById(R.id.descriptionOrganisation);
	    Organisations org = new Organisations(); 
	    org.setLibelleOrganisation(titreOrg.getText().toString()); 
	    org.setDescriptionOrganisation(descriptionOrg.getText().toString());
	    
	    try{
	    	OrgnaisationService uc = new OrgnaisationService(); 
	    	
			    if(Utility.isNotNull(titreOrg.getText().toString())){
			    	
			    	uc.create(org); 
			    	Log.e("Organisation creee avec succes  ", "ok");
			 		final Intent intent = new Intent(AjouterOrganisationActivity.this, LivreurAccueilActivity.class);
					startActivity(intent);
			    	
			    	
			    }else {
			    	 Toast	toast = Toast.makeText(getApplication(), "Merci de renseignez le titre de l'organisation !", Toast.LENGTH_LONG);
		             toast.show();
			    }
	    }catch(Exception ex) {
	    	ex.printStackTrace();
		    return;
	    }
    }
	
}
