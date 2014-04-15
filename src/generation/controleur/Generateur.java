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
	public void generer(ArrayList<String> listeModule, String nomProjet, String destination){
		
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
		for(int i = 0; i<listeModule.size(); i++){
			String module = listeModule.get(i);
			
			File dirSourceMod = new File("/home/v/vidalle/Projet-Nexus/ApplicationGeneree/modules/"+module);
			File dirDestMod = new File(destination + "/" + nomProjet +"/modules/"+module);
			try {
				generation.controleur.Utils.copy(dirSourceMod, dirDestMod);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
	
}
