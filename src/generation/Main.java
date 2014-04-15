package generation;

import java.util.ArrayList;

import generation.controleur.Generateur;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<String> listeModule = new ArrayList<String>();
		listeModule.add("module2");
		
		Generateur g = new Generateur();
		g.generer(listeModule, "testProjet1", "/home/v/vidalle/Projet-Nexus");

	}

}
