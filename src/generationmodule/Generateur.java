package generationmodule;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import rmi.client.core.Client;

public class Generateur {
	
	String nm;
	String cheminServeur;
	String cheminClient;
	
//	public static void main(String[] args) {
//		String nm = "Packtest";
//		String chemin = "src/rmi/";
//		Generateur g = new Generateur(nm, chemin);
//		g.ajouterFonction("public float nbCaca(int pipi)", "float");
//		g.fermerLesFichiers();
//	}
	
	public Generateur(String nm, String chemin){
		this.nm = nm;
		String cheminAbsolu = new File(chemin).getAbsolutePath();
		String nomProjet = new File(chemin).getName();
		cheminServeur = cheminAbsolu+"/"+nomProjet+"-serveur/";
		cheminClient = cheminAbsolu+"/"+nomProjet+"-client/";
		genererClient();
		genererGestInterface();
		genererGestImpl();
	}
	
	public void genererClient(){
		PrintWriter generateur;

	    try {
	    	File dir = new File(cheminClient + "src/client/modules/" + nm);
			dir.mkdir();
			generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminClient+ "src/client/modules/"+nm+"/Client"+nm+".java")));
			generateur.println("package client.modules."+nm+";");
			generateur.println("import client.core.Client;");
			generateur.println("import commun.modules."+nm+".Gest"+nm+"Interface;");
			generateur.println("public class Client"+nm+" extends Client {");
			generateur.println("\tGest"+nm+"Interface gestI;");
			generateur.println("\tpublic Client"+nm+"(int p, String aS) {");
			generateur.println("\t\tsuper(p, aS);");
			generateur.println("\t\tgestI = (Gest"+nm+"Interface) getObjetRegistry(\"gest"+nm+"\");");
			generateur.println("\t}");
			generateur.println("}");
		    generateur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void genererGestInterface(){
		PrintWriter generateur;

	    try {
	    	File dir = new File(cheminClient + "src/commun/modules/" + nm);
			dir.mkdir();
			generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminClient+"src/commun/modules/"+nm+"/Gest"+nm+"Interface.java")));
			generateur.println("package commun.modules."+nm+";");
			generateur.println("import java.rmi.Remote;");
			generateur.println("import java.rmi.RemoteException;");
			generateur.println("public interface Gest"+nm+"Interface extends Remote {");
		    generateur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	    
	    try {
	    	File dir = new File(cheminServeur + "src/commun/modules/" + nm);
			dir.mkdir();
			generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminServeur +"src/commun/modules/"+nm+"/Gest"+nm+"Interface.java")));
			generateur.println("package commun.modules."+nm+";");
			generateur.println("import java.rmi.Remote;");
			generateur.println("import java.rmi.RemoteException;");
			generateur.println("public interface Gest"+nm+"Interface extends Remote {");
		    generateur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void genererGestImpl(){
		PrintWriter generateur;
//
	    try {
	    	File dir = new File(cheminServeur + "src/serveur/modules/" + nm);
			dir.mkdir();
			generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminServeur+"src/serveur/modules/"+nm+"/Gest"+nm+"Impl.java")));
			generateur.println("package serveur.modules."+nm+";");
			generateur.println("import java.rmi.RemoteException;");
			generateur.println("import java.rmi.server.UnicastRemoteObject;");
			generateur.println("import commun.modules."+nm+".Gest"+nm+"Interface;");
			
			generateur.println("public class Gest"+nm+"Impl extends UnicastRemoteObject implements Gest"+nm+"Interface {");
			generateur.println("\tpublic Gest"+nm+"Impl() throws RemoteException {");
			generateur.println("\t\tsuper();");
			generateur.println("\t}");
			// Les fonctions
		    generateur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void ajouterFonction(String signature, String retour){
		PrintWriter generateur;
			    try {
					generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminServeur+"src/serveur/modules/"+nm+"/Gest"+nm+"Impl.java", true)));
					generateur.println("\t\tpublic "+retour+" "+signature+" {");
					generateur.println("\t\t\t//TODO : Ecrire le corps de la méthode ici");
					if (retour.equals("objet")) {
						generateur.println("\t\t\treturn null;");
					}
					else if (retour.equals("boolean")) {
						generateur.println("\t\t\treturn false;");
					}
					else if (retour.equals("void")) {
						generateur.println("\t\t\t");
					}
					else {
						generateur.println("\t\t\treturn 0;");
					}
					generateur.println("\t\t}");
				    generateur.close();
				    generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminServeur+"src/commun/modules/"+nm+"/Gest"+nm+"Interface.java", true)));
				    generateur.println("\t\tpublic "+retour+" "+signature+" throws RemoteException ;");
				    generateur.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
	}
	
	public void fermerLesFichiers(){
		PrintWriter generateur;
		    try {
				generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminServeur+"src/serveur/modules/"+nm+"/Gest"+nm+"Impl.java", true)));
				generateur.println("}");
			    generateur.close();
			    generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminServeur+"src/commun/modules/"+nm+"/Gest"+nm+"Interface.java", true)));
			    generateur.println("}");
			    generateur.close();
			    generateur =  new PrintWriter(new BufferedWriter(new FileWriter(cheminClient+"src/commun/modules/"+nm+"/Gest"+nm+"Interface.java", true)));
			    generateur.println("}");
			    generateur.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
	}
}
