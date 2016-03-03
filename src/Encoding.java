
public enum Encoding {

	/**
	 * Enumeration pour les différents types d'encodages
	 */
	MD5("MD5"), SHA1("SHA-1"), SHA256("SHA-256");
	
	private String encoding = "";
	
	Encoding(String encoding){
		this.encoding = encoding;
	}
	
	/**
	 * Retourne l'encodage sélectionné
	 * @return - l'encodage correspondant sous forme de chaine 
	 */
	public String getEncoding(){
		return encoding;
	}
}
