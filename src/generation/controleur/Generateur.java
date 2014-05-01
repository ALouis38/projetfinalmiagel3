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
	
	boolean genChat=false;
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
		File dirI = new File(path + "/commun");
		dirI.mkdir();
		
		//dossier coreServeur
		File dirSourceCoreS = new File(config.getHome() + "/src/serveur/core");
		File dirDestCoreS = new File(path +"/serveur/core");
		try {
			generation.controleur.Utils.copy(dirSourceCoreS, dirDestCoreS);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//dossier coreInterface
		File dirSourceCoreI = new File(config.getHome() + "/src/commun/core");
		File dirDestCoreI = new File(path +"/commun/core");
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
			File dirSourceModS = new File(config.getHome() + "/src/serveur/modules/"+module);
			File dirDestModS = new File(path + "/serveur/modules/"+module);
			try {
				generation.controleur.Utils.copy(dirSourceModS, dirDestModS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		

		
		
		//dossier moduleInterface
		File dirModuleInterface = new File(path + "/commun/modules");
		dirModuleInterface.mkdir();
		
		for(int i = 0; i<listeModule.size(); i++){
			String module = listeModule.get(i);
			File dirSourceModI = new File(config.getHome() + "/src/commun/modules/"+module);
			File dirDestModI = new File(path + "/commun/modules/"+module);
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
		
		//lanceur serveur
		File lanceurSourceS = new File(config.getHome() + "/src/serveur/LanceurServeur.java");
		File lanceurDestS = new File(pat +"/src/serveur/LanceurServeur.java");
		try {
			generation.controleur.Utils.copy(lanceurSourceS, lanceurDestS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/////////////////////////////////////////////////////GENERATION MODULE ASSOCIE A CHAT/////////////////////////////////////////////////////
		
		if(genChat){
			
			//UTILISATEUR//
			File dirSourceModI2 = new File(config.getHome() + "/src/commun/modules/Utilisateur");
			File dirDestModI2 = new File(path + "/commun/modules/Utilisateur");
			try {
				generation.controleur.Utils.copy(dirSourceModI2, dirDestModI2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			File dirSourceModS3 = new File(config.getHome() + "/src/serveur/modules/Utilisateur");
			File dirDestModS3 = new File(path + "/serveur/modules/Utilisateur");
			try {
				generation.controleur.Utils.copy(dirSourceModS3, dirDestModS3);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//NOTICATION//
			
			File dirSourceModS5 = new File(config.getHome() + "/src/commun/modules/Notification");
			File dirDestModS5 = new File(path + "/commun/modules/Notification");
			try {
				generation.controleur.Utils.copy(dirSourceModS5, dirDestModS5);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//MESSAGE//
			File dirSourceModI3 = new File(config.getHome() + "/src/commun/modules/chat/message");
			File dirDestModI3 = new File(path + "/commun/modules/chat/message");
			try {
				generation.controleur.Utils.copy(dirSourceModI3, dirDestModI3);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

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
			File dirI = new File(path + "/commun");
			dirI.mkdir();
			
			//dossier coreClient
			File dirSourceCoreS = new File(config.getHome() + "/src/client/core");
			File dirDestCoreS = new File(path +"/client/core");
			try {
				generation.controleur.Utils.copy(dirSourceCoreS, dirDestCoreS);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			//dossier coreInterface
			File dirSourceCoreI = new File(config.getHome() + "/src/commun/core");
			File dirDestCoreI = new File(path +"/commun/core");
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
				File dirSourceModS = new File(config.getHome() + "/src/client/modules/"+module);
				File dirDestModS = new File(path + "/client/modules/"+module);
				try {
					generation.controleur.Utils.copy(dirSourceModS, dirDestModS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			//dossier moduleInterface
			File dirModuleInterface = new File(path + "/commun/modules");
			dirModuleInterface.mkdir();
			
			for(int i = 0; i<listeModule.size(); i++){
				String module = listeModule.get(i);
				File dirSourceModI = new File(config.getHome() + "/src/commun/modules/"+module);
				File dirDestModI = new File(path + "/commun/modules/"+module);
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
			
			//lanceur client
			File lanceurSourceC = new File(config.getHome() + "/src/client/LanceurClient.java");
			File lanceurDestC = new File(pat +"/src/client/LanceurClient.java");
			try {
				generation.controleur.Utils.copy(lanceurSourceC, lanceurDestC);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
/////////////////////////////////////////////////////GENERATION MODULE ASSOCIE A CHAT/////////////////////////////////////////////////////

			
			if(genChat){
				
				//UTILISATEUR//
				File dirSourceModS2 = new File(config.getHome() + "/src/client/modules/Utilisateur");
				File dirDestModS2 = new File(path + "/client/modules/Utilisateur");
				try {
					generation.controleur.Utils.copy(dirSourceModS2, dirDestModS2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				File dirSourceModI3 = new File(config.getHome() + "/src/commun/modules/Utilisateur");
				File dirDestModI3 = new File(path + "/commun/modules/Utilisateur");
				try {
					generation.controleur.Utils.copy(dirSourceModI3, dirDestModI3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//NOTIFICATION//
				File dirSourceModS3 = new File(config.getHome() + "/src/client/modules/Notification");
				File dirDestModS3 = new File(path + "/client/modules/Notification");
				try {
					generation.controleur.Utils.copy(dirSourceModS3, dirDestModS3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				File dirSourceModI4 = new File(config.getHome() + "/src/commun/modules/Notification");
				File dirDestModI4 = new File(path + "/commun/modules/Notification");
				try {
					generation.controleur.Utils.copy(dirSourceModI4, dirDestModI4);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//MESSAGE//
				File dirSourceModI5 = new File(config.getHome() + "/src/commun/modules/chat/message");
				File dirDestModI5 = new File(path + "/commun/modules/chat/message");
				try {
					generation.controleur.Utils.copy(dirSourceModI5, dirDestModI5);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}

	public void setGenChat(boolean b) {
		genChat = b;
		
	}
	
}
