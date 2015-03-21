package org.cnam.livreur;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class  PrincipaleFragmentActivity extends FragmentActivity{

	
	protected abstract Fragment creerFragment();
	  
  	/*
  	 * INITIALISATION DE L'ACTIVITE
  	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	 super.onCreate(savedInstanceState);
    	
    	 setContentView(R.layout.accueil_conteneur_fragment);
      
         FragmentManager manager = getSupportFragmentManager();
         Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

         if (fragment == null) {
             fragment = creerFragment();
          
             manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
         }
    }
}
