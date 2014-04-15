package generation.controleur;

import generation.modele.Module;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import generation.controleur.Utils;

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
		
		//dossier module
		File dirModules = new File(destination + "/" + nomProjet +"/modules");
		dirModules.mkdir();
		
		//contenu du dossier core
		File dirSourceCore = new File("/home/v/vidalle/Projet-Nexus/ApplicationGeneree/core");
		File dirDestCore = new File(destination + "/" + nomProjet +"/core");
		try {
			generation.controleur.Utils.copy(dirSourceCore, dirDestCore);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//contenu du dossier lib
		File dirSourceLib = new File("/home/v/vidalle/Projet-Nexus/ApplicationGeneree/lib");
		File dirDestLib = new File(destination + "/" + nomProjet +"/lib");
		try {
			generation.controleur.Utils.copy(dirSourceLib, dirDestLib);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//contenu du dossier modules
		
		//contenu du dossier src
		File dirSourceSrc = new File("/home/v/vidalle/Projet-Nexus/ApplicationGeneree/src");
		File dirDestSrc = new File(destination + "/" + nomProjet +"/src");
		try {
			generation.controleur.Utils.copy(dirSourceSrc, dirDestSrc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fichier à la racine du projet
		File dirPro = new File(destination + "/properties");

	}
	
	public void generer2(ArrayList<Module> listeModule, String nomProjet, String destination){
		//dossier global du projet
		File dirDest = new File(destination + "/" + nomProjet);
		dirDest.mkdir();
		
		//dossier source
		File dirSource = new File("/home/v/vidalle/Projet-Nexus/ApplicationGeneree");
		
		//execution
		try {
			generation.controleur.Utils.copy(dirSource, dirDest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Module> listerModule(){
		return null;
	}
}
