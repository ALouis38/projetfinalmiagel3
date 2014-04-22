package rmi.serveur.modules.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.zip.*;

import rmi.interfaces.modules.zip.GestZipInterface;

public class GestZipImpl extends UnicastRemoteObject implements GestZipInterface {

	public GestZipImpl() throws RemoteException{
	}
	/**
	 * Créé une archive Zip dans le répertoire donné en paramètres, contenant
	 * les fichiers dont la liste est également donnée en paramètre
	 * 
	 * @param fichiers
	 * @param repertoire
	 */
	public void compression(String[] fichiers, String repertoire) {
		byte[] data = null;
		try {
			// Création de la future archive
			FileOutputStream archiveZip = new FileOutputStream(repertoire
					+ "/archive.zip");
			// Création d'un buffer de sortie vers l'archive zip
			BufferedOutputStream bSortie = new BufferedOutputStream(archiveZip);
			// Création d'un flux d'ecriture Zip vers l'archive (via le buffer)
			ZipOutputStream fZip = new ZipOutputStream(bSortie);
			fZip.setMethod(ZipOutputStream.DEFLATED);
			fZip.setLevel(9);
			// Entrées dans l'archive
			int i;
			for (i = 0; i < fichiers.length; i++) {
				File fCourant = new File(fichiers[i]);
				data = null;
				data = new byte[(int) fCourant.length()];
				// Lister les fichiers à compresser
				FileInputStream fFichier = new FileInputStream(fichiers[i]);
				// Création d'un buffer d'entrée
				BufferedInputStream bFichier = new BufferedInputStream(fFichier);
				// Création d'une entrée Zip
				ZipEntry eFichier = new ZipEntry(fichiers[i]);
				// Affectation cette entrée au flux de sortie
				fZip.putNextEntry(eFichier);
				// Ecriture de l'archive
				bFichier.read(data, 0, data.length);
				fZip.write(data, 0, data.length);
				fZip.closeEntry();
				bFichier.close();

			}
			fZip.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Décompresse l'archive dont le nom (sans ".zip") est donné en paramètre
	 * dans le repertoire également donné en paramètre
	 * 
	 * @param nomArchive
	 * @param repertoire
	 */
	public void decompression(String nomArchive, String repertoire) {
		try {
			// Recuperation de l'archive
			ZipFile fZippe = new ZipFile(repertoire + "/" + nomArchive + ".zip");
			// Création du répertoire de décompression
			File repD = new File(repertoire + "/" + nomArchive);
			if (!repD.exists()) {
				new File(repertoire + "/" + nomArchive).mkdir();
			}
			// Recupére toutes les entrees de l'archive
			Enumeration zEntrees = fZippe.entries();
			// Traitement des entrees
			while (zEntrees.hasMoreElements()) {
				// Récuperation de l'entrée suivante
				ZipEntry zEntree = (ZipEntry) zEntrees.nextElement();
				// Création des flux
				FileOutputStream fSortant = new FileOutputStream(repertoire + "/" + nomArchive
						+ "/" + zEntree.getName());
				BufferedOutputStream bSortant = new BufferedOutputStream(
						fSortant);
				// Récupération
				writeFile(fZippe.getInputStream(zEntree), bSortant);
				bSortant.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeFile(InputStream in, OutputStream out) {
		byte[] data = new byte[1024];
		int taille;
		try {
			while ((taille = in.read(data)) >= 0) {
				out.write(data, 0, taille);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
