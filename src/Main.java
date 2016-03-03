
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Encryption encr = new Encryption("password", Encoding.MD5);
		System.out.println(encr.getPasswordToEncrypt());
		System.out.println(encr.getPasswordEncrypted());
	}

}
