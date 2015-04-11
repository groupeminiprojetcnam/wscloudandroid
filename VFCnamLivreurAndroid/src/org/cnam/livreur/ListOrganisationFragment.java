package org.cnam.livreur;

import java.util.ArrayList;

import org.cnam.cloud.wsrest.model.ClientsOrganisationsService;
import org.cnam.cloud.wsrest.model.ContainerClientsOrganisations;
import org.cnam.cloud.wsrest.model.DemandeAccesBoiteLettres;
import org.cnam.cloud.wsrest.model.LivreursClients;
import org.cnam.cloud.wsrest.model.Organisations;
import org.cnam.cloud.wsrest.model.OrgnaisationService;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListOrganisationFragment extends ListFragment{
	


	private ArrayList<Organisations> organisations; 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	 super.onCreate(savedInstanceState);
	    	 setHasOptionsMenu(true);
	    	 /*
	    	  * recuperer la liste des organisation
	    	  */
	    	 getActivity().setTitle("Liste des Organisations");
	    	 OrgnaisationService  orgServ = new OrgnaisationService(); 
	    	 organisations = new ArrayList<Organisations>(orgServ.getAllOrganisations()); 
	    	 OrganisationAdapter organisationsAdapter = new OrganisationAdapter(organisations); 
	    	 setListAdapter(organisationsAdapter); 
	    	 setRetainInstance(true);
	    	 
	    	 
	    	 
	    	 
	 }
	 
	 
	 
	    @Override
	    @TargetApi(11)
	    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
	    	View v = super.onCreateView(inflater, parent, savedInstanceState);
	    	ListView listView = (ListView)v.findViewById(android.R.id.list);
	    	
	    	 
	    	 return v;
	    }
	
	    
	    public void onListItemClick(ListView l, View v, int position, long id) {
	        /*
	         * RECUPERATION DE LA LIGNE SELECTIONNEE
	         */
	    	Organisations organisations = ((OrganisationAdapter)getListAdapter()).getItem(position);
	    	Log.e("ID organisation selectionnée   est    -->  ", "               "+organisations.getIdOrganisation()); 
	       	VaiablesGlobales vg = (VaiablesGlobales)getActivity().getApplication();
        	DemandeAccesBoiteLettres accesBoiteLettres =new DemandeAccesBoiteLettres();
        	LivreursClients livreursClients = null; 
        	livreursClients = vg.getLivreursClients(); 
        	
        	Log.e("ID Livreur   est    -->  ", "  "+livreursClients.getIdLivreur());
        	Log.e("ID Clientt    -->  ", "  "+livreursClients.getIdClient());
        	/*
        	 * Verifier si l'organisation selectionnee par le client est choisie par le client lors de la creation de son compte 
        	 */
        	ClientsOrganisationsService cos = new ClientsOrganisationsService(); 
        	ContainerClientsOrganisations container = cos.verifierAssociationClientOrganisations(livreursClients.getIdClient().toString(), organisations.getIdOrganisation().toString());
        	if(container != null  && container.getClientsOrganisations_list().size() >0) {
        		Log.e(" OK OOKKKKKKKKKKKKKKKKKKKKKKKK", "      Organisation accespetee");
        		/*
        		 * lancer la boite de dialogie pour l'ouverture de la boite aux lettres
        		 */
                  vg.setOrganisation(organisations); 

        		Intent ii = new Intent(getActivity(),  DialogAccesBoitesAuxLettres.class);
           	 	startActivityForResult(ii, 0);
        			
        	}else {
        		Log.e(" KOOOOOOOOOOOOOOOOOOOOOOOOOOOO ", "      Organisation NON  accespetee");
            	Toast toast = Toast.makeText(getActivity(), "OOPS !!! L'organisation << "+organisations.getLibelleOrganisation() +" >> n'est pas autorisée par le client !", Toast.LENGTH_LONG);
                toast.show();
        	}
        	
	       
	    }
	    
	    
	
		private class OrganisationAdapter extends ArrayAdapter<Organisations> {
	    	
	    	
	    	public OrganisationAdapter(ArrayList<Organisations> listTemplate) {
	    		super(getActivity(), android.R.layout.simple_list_item_1, listTemplate); 
	    	}
	    	
	    	
	  	   @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	 		   if(convertView == null) {
	 			   convertView = getActivity().getLayoutInflater().inflate(R.layout.list_organisations, null); 
	 		   }
	 		  Organisations organisations = getItem(position); 
	 		   
	 		  TextView textViewTitre = (TextView)convertView.findViewById(R.id.organisation_titre_list_item_titleTextView); 
   		      textViewTitre.setText(organisations.getLibelleOrganisation()); 
   		   
   		       TextView textViewDescription = (TextView)convertView.findViewById(R.id.organisation__description_list_item_titleTextView); 
   		       textViewDescription.setText(organisations.getDescriptionOrganisation()); 
   		      return convertView; 
	  	   }
	    	
	    }
		
		
	    @Override
	    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	        super.onCreateOptionsMenu(menu, inflater);
	        inflater.inflate(R.menu.fragment_menu_icons_bouton_retour_board, menu);
	    }
		
		
		
		
}
