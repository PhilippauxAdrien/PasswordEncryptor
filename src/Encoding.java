
public enum Encoding {

	MD5("MD5"), SHA1("SHA-1"), SHA256("SHA-256");
	
	private String encoding = "";
	
	Encoding(String encoding){
		this.encoding = encoding;
	}
	
	public String getEncoding(){
		return encoding;
	}
}
