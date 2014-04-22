package generation.controleur;

import generation.modele.EnsembleModule;
import generation.modele.Module;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import config.Configuratione;
import generation.controleur.Utils;

public class Generateur {

	EnsembleModule ens = new EnsembleModule();
	Configuratione config = new Configuratione();
	
	/**
	 * 
	 * @param listeModule
	 * @param nomProjet
	 * @param destination
	 */
	public void genererServeur(ArrayList<String> listeModule, String nomProjet, String destination){
		
		//dossier global du projet
		File dir = new File(destination + "/" + nomProjet);
		dir.mkdir();
		String deb = destination + "/" + nomProjet;
		
		//dossier global Serveur
		File dirServ = new File(deb + "/" + nomProjet + "-serveur");
		dirServ.mkdir();
		String pat = deb + "/" + nomProjet + "-serveur";
		
		//dossier src
		String path = pat + "/src";
		File dirSrc = new File(path);
		dirSrc.mkdir();
		
		//dossier serveur
		File dirS = new File(path + "/serveur");
		dirS.mkdir();
		
		//dossier interface
		File dirI = new File(path + "/interfaces");
		dirI.mkdir();
		
		//dossier coreServeur
		File dirSourceCoreS = new File(config.getHome() + "/src/rmi/serveur/coreserveur");
		File dirDestCoreS = new File(path +"/serveur/core");
		try {
			generation.controleur.Utils.copy(dirSourceCoreS, dirDestCoreS);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//dossier coreInterface
		File dirSourceCoreI = new File(config.getHome() + "/src/rmi/interfaces/core");
		File dirDestCoreI = new File(path +"/interfaces/core");
		try {
			generation.controleur.Utils.copy(dirSourceCoreI, dirDestCoreI);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//dossier moduleServeur
		File dirModuleServeur = new File(path + "/serveur/modules");
		dirModuleServeur.mkdir();
		
		for(int i = 0; i<listeModule.size(); i++){
			String module = listeModule.get(i);
			File dirSourceModS = new File(config.getHome() + "/src/rmi/serveur/modulesserveur/"+module);
			File dirDestModS = new File(path + "/serveur/modules/"+module);
			try {
				generation.controleur.Utils.copy(dirSourceModS, dirDestModS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dossier moduleInterface
		File dirModuleInterface = new File(path + "/interfaces/modules");
		dirModuleInterface.mkdir();
		
		for(int i = 0; i<listeModule.size(); i++){
			String module = listeModule.get(i);
			File dirSourceModI = new File(config.getHome() + "/src/rmi/interfaces/modules/"+module);
			File dirDestModI = new File(path + "/interfaces/modules/"+module);
			try {
				generation.controleur.Utils.copy(dirSourceModI, dirDestModI);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//contenu du dossier lib
		File dirLib = new File(pat + "/lib");
		dirLib.mkdir();
		
		//contenu du dossier bin
		File dirSourceBin = new File(config.getHome() + "/bin");
		File dirDestBin = new File(pat +"/bin");
		try {
			generation.controleur.Utils.copy(dirSourceBin, dirDestBin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<String> listeModule(){
		return ens.getListeString();
	}
	
	public void genererClients(ArrayList<String> listeModule, String nomProjet, String destination){

			//dossier global Client
			String deb = destination + "/" + nomProjet;
			String pat = deb + "/" + nomProjet + "-client";
			File dirServ = new File(pat);
			dirServ.mkdir();
			
			//dossier src
			String path = pat + "/src";
			File dirSrc = new File(path);
			dirSrc.mkdir();
			
			//dossier client
			File dirS = new File(path + "/client");
			dirS.mkdir();
			
			//dossier interface
			File dirI = new File(path + "/interfaces");
			dirI.mkdir();
			
			//dossier coreClient
			File dirSourceCoreS = new File(config.getHome() + "/src/rmi/client/coreclient");
			File dirDestCoreS = new File(path +"/client/core");
			try {
				generation.controleur.Utils.copy(dirSourceCoreS, dirDestCoreS);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			//dossier coreInterface
			File dirSourceCoreI = new File(config.getHome() + "/src/rmi/interfaces/core");
			File dirDestCoreI = new File(path +"/interfaces/core");
			try {
				generation.controleur.Utils.copy(dirSourceCoreI, dirDestCoreI);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			//dossier moduleClient
			File dirModuleServeur = new File(path + "/client/modules");
			dirModuleServeur.mkdir();
			
			for(int i = 0; i<listeModule.size(); i++){
				String module = listeModule.get(i);
				File dirSourceModS = new File(config.getHome() + "/src/rmi/client/modulesclient/"+module);
				File dirDestModS = new File(path + "/client/modules/"+module);
				try {
					generation.controleur.Utils.copy(dirSourceModS, dirDestModS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//dossier moduleInterface
			File dirModuleInterface = new File(path + "/interfaces/modules");
			dirModuleInterface.mkdir();
			
			for(int i = 0; i<listeModule.size(); i++){
				String module = listeModule.get(i);
				File dirSourceModI = new File(config.getHome() + "/src/rmi/interfaces/modules/"+module);
				File dirDestModI = new File(path + "/interfaces/modules/"+module);
				try {
					generation.controleur.Utils.copy(dirSourceModI, dirDestModI);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//contenu du dossier lib
			File dirLib = new File(pat + "/lib");
			dirLib.mkdir();
			
			//contenu du dossier bin
			File dirSourceBin = new File(config.getHome() + "/bin");
			File dirDestBin = new File(pat +"/bin");
			try {
				generation.controleur.Utils.copy(dirSourceBin, dirDestBin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
