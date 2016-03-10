public class Main {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Encryption encr = new Encryption("password", Encoding.MD5, 32);
		System.out.println(encr.getPasswordToEncrypt());
		System.out.println(encr.getPasswordEncrypted());
		
	}

}
