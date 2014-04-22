package generationmodule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import rmi.client.core.Client;
import rmi.interfaces.modules.zip.GestZipInterface;

public class Generateur {
	
	String nm;
	String chemin;
	
	public static void main(String[] args) {
		String nm = "Chat";
		String chemin = "src/rmi/";
		Generateur g = new Generateur(nm, chemin);
	}
	
	public Generateur(String nm, String chemin){
		this.nm = nm;
		this.chemin = chemin;
		genererClient();
		genererGestInterface();
		genererGestImpl();
	}
	
	public void genererClient(){
		PrintWriter generateur;

	    try {
	    	File dir = new File(chemin + "client/modulesclient/" + nm);
			dir.mkdir();
			generateur =  new PrintWriter(new BufferedWriter(new FileWriter(chemin+"client/modulesclient/"+nm+"/Client"+nm+".java")));
			generateur.println("package rmi.client.modulesclient."+nm+";");
			generateur.println("import rmi.client.coreclient.Client;");
			generateur.println("import rmi.interfaces.modules."+nm+".Gest"+nm+"Interface;");
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
	    	File dir = new File(chemin + "interfaces/modules/" + nm);
			dir.mkdir();
			generateur =  new PrintWriter(new BufferedWriter(new FileWriter(chemin+"interfaces/modules/"+nm+"/Gest"+nm+"Interface.java")));
			generateur.println("package rmi.interfaces.modules."+nm+";");
			generateur.println("import java.rmi.Remote;");
			generateur.println("import java.rmi.RemoteException;");
			generateur.println("public interface Gest"+nm+"Interface extends Remote {");
			// Les fonctions
			generateur.println("}");
		    generateur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void genererGestImpl(){
		PrintWriter generateur;

	    try {
	    	File dir = new File(chemin + "serveur/modulesserveur/" + nm);
			dir.mkdir();
			generateur =  new PrintWriter(new BufferedWriter(new FileWriter(chemin+"serveur/modulesserveur/"+nm+"/Gest"+nm+"Impl.java")));
			generateur.println("package rmi.serveur.modulesserveur."+nm+";");
			generateur.println("import java.rmi.RemoteException;");
			generateur.println("import java.rmi.server.UnicastRemoteObject;");
			generateur.println("import rmi.interfaces.modules."+nm+".Gest"+nm+"Interface;");
			
			generateur.println("public class Gest"+nm+"Impl extends UnicastRemoteObject implements Gest"+nm+"Interface {");
			generateur.println("\tpublic Gest"+nm+"Impl() throws RemoteException {");
			generateur.println("\t\tsuper();");
			generateur.println("\t}");
			generateur.println("}");
			// Les fonctions
		    generateur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
