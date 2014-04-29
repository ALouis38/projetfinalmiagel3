package rmi.interfaces.modules.Utilisateur;

import java.io.Serializable;

public class Utilisateur implements Serializable {
	
	String ip;
	int portRegistry;
	
	public int getPortRegistry() {
		return portRegistry;
	}

	public void setPortRegistry(int portRegistry) {
		this.portRegistry = portRegistry;
	}

	public Utilisateur(String ip, int portReg){
		portRegistry = portReg;
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
