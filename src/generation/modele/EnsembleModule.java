package generation.modele;

import java.util.ArrayList;

public class EnsembleModule {

	public ArrayList<String> listeString;
	public ArrayList<Module> listeObjet;
	
	public EnsembleModule(){
		listeObjet = new ArrayList<Module>();
		listeString = new ArrayList<String>();
		
		Module module1 = new Module();
		listeObjet.add(module1);
		listeString.add("module1");
		
		Module module2 = new Module();
		listeObjet.add(module2);
		listeString.add("module2");
	}

	public ArrayList<String> getListeString() {
		return listeString;
	}

	public ArrayList<Module> getListeObjet() {
		return listeObjet;
	}

}
