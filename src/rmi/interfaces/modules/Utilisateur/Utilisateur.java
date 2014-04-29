package rmi.interfaces.modules.Utilisateur;

public class Utilisateur {
	
	String ip;
	
	public Utilisateur(String ip){
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
