package nexus.generation.modele;

import java.util.ArrayList;

public class EnsembleModule {

	public ArrayList<String> listeString;
	public ArrayList<Module> listeObjet;
	
	public EnsembleModule(){
		listeObjet = new ArrayList<Module>();
		listeString = new ArrayList<String>();
		
		Module moduleChat = new Module();
		listeObjet.add(moduleChat);
		listeString.add("chat");
		
		Module moduleZip = new Module();
		listeObjet.add(moduleZip);
		listeString.add("zip");
	}

	public ArrayList<String> getListeString() {
		return listeString;
	}

	public ArrayList<Module> getListeObjet() {
		return listeObjet;
	}

}
