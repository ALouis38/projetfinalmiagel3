package generation.modele;

import java.util.ArrayList;

public class EnsembleModule {

	public ArrayList<String> listeString;
	public ArrayList<Module> listeObjet;
	
	public EnsembleModule(){
		listeObjet = new ArrayList<Module>();
		listeString = new ArrayList<String>();
	}
}
