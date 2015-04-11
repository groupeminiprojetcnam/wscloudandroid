package org.cnam.clients;

import java.util.ArrayList;

import org.cnam.cloud.wsrest.model.OrganisationService;
import org.cnam.cloud.wsrest.model.Organisations;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListOrganisationFragment extends ListFragment{

	private ArrayList<Organisations> organisations; 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	 super.onCreate(savedInstanceState);
	    	 setHasOptionsMenu(true);
	    	 /*
	    	  * recuperer la liste des organisation
	    	  */
	    	 OrganisationService  orgServ = new OrganisationService(); 
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
	    	
	    	
	        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {   
	      	     registerForContextMenu(listView);
	      }else {
	    	  listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL); 
	    	  listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

				@Override
				public boolean onCreateActionMode(ActionMode mode, Menu menu) {
					MenuInflater inflater = mode.getMenuInflater(); 
					inflater.inflate(R.menu.menu_select_organisation, menu); 
					return true;
				}

				@Override
				public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean onActionItemClicked(ActionMode mode,
						MenuItem item) {
					switch (item.getItemId()) {
					
					case R.id.menu_item_save_organisation:
						OrganisationAdapter adaptateur = (OrganisationAdapter)getListAdapter();
						VaiablesGlobales vg = (VaiablesGlobales)getActivity().getApplication();
						vg.getListOrganisation().clear(); 
						 for (int i = adaptateur.getCount() - 1; i >= 0; i--) {
							 if(getListView().isItemChecked(i)) {
								 Log.e("ID ORG  -->   ", adaptateur.getItem(i).getLibelleOrganisation());
								 vg.getListOrganisation().add(adaptateur.getItem(i).getIdOrganisation()); 
							 }
						 }
						 mode.finish(); 
						 getActivity().finish(); 
						return true; 
					
					
					default:
						return false;
					}	
					
				}

				@Override
				public void onDestroyActionMode(ActionMode mode) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onItemCheckedStateChanged(ActionMode mode,
						int position, long id, boolean checked) {
					// TODO Auto-generated method stub
					
				}
	    		  
	    	  });  
	    	  
	    	  
	    	  
	    	  
	    	  
	      }
	    	 
	    	 return v;
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
}
