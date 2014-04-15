package generation.controleur;

import java.io.*;

public class Utils {
	
	/**
	 * utilitaire de copie
	 * @param inStream
	 * @param outStream
	 * @param bufferSize
	 * @throws IOException
	 */
	public static void copy(final InputStream inStream, final OutputStream outStream, final int bufferSize) throws IOException {
	 final byte[] buffer = new byte[bufferSize];
	 int nbRead;
	 while ((nbRead = inStream.read(buffer)) != -1) {
	  outStream.write(buffer, 0, nbRead);
	 }
	}
	
	/**
	 * copie de dossier
	 * @param from
	 * @param to
	 * @throws IOException
	 */
	public static void copyDirectory(final File from, final File to) throws IOException {
	 if (! to.exists()) {
	  to.mkdir();
	 }
	 final File[] inDir = from.listFiles();
	 for (int i = 0; i < inDir.length; i++) {
	  final File file = inDir[i];
	  copy(file, new File(to, file.getName()));
	 }
	}
	
	/**
	 * copie de fichier
	 * @param from
	 * @param to
	 * @throws IOException
	 */
	public static void copyFile(final File from, final File to) throws IOException {
	      final InputStream inStream = new FileInputStream(from);
	      final OutputStream outStream = new FileOutputStream(to);
	      if (from.length() > 0){
	        copy(inStream, outStream, (int) Math.min(from.length(), 4*1024));
	      }
	      inStream.close();
	      outStream.close();
	   } 
	
	/**
	 * Procedure de copie indiférente dossier-fichier
	 * @param from
	 * @param to
	 * @throws IOException
	 */
	public static void copy(final File from, final File to) throws IOException {
	 if (from.isFile()) {
	  copyFile(from, to);
	 } else if (from.isDirectory()){
	  copyDirectory(from, to);
	 } else {
	  throw new FileNotFoundException(from.toString() + " does not exist" );
	 }
	} 

}
