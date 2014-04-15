package generation.controleur;

import generation.modele.Module;
import java.io.File;
import java.util.ArrayList;

public class Generateur {

	/**
	 * 
	 * @param listeModule
	 * @param nomProjet
	 * @param destination
	 */
	public void generer(ArrayList<Module> listeModule, String nomProjet, String destination){
		
		//dossier global du projet
		File dir = new File(destination + "/" + nomProjet);
		dir.mkdir();
		
		//dossiers à la racine du projet
		File dirCore = new File(destination + "/" + nomProjet +"/core");
		dirCore.mkdir();
		
		File dirLib = new File(destination + "/" + nomProjet +"/lib");
		dirLib.mkdir();
		
		File dirModules = new File(destination + "/" + nomProjet +"/modules");
		dirModules.mkdir();
		
		File dirSrc = new File(destination + "/" + nomProjet +"/src");
		dirSrc.mkdir();
		
		//contenu du dossier core
		
		//contenu du dossier lib
		
		//contenu du dossier modules
		
		//contenu du dossier src
		
		//fichier à la racine du projet
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Module> listerModule(){
		return null;
	}
}
