import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

	private String passwordToEncrypt = "";
	private String passwordEncrypted = "";
	private String encodage = "";
	private static MessageDigest md;

	/**
	 * Créé un type Encryption pour ensuite pouvoir encrypter le mdp
	 * @param passwordToEncrypt - mot de passe à encrypter
	 * @param encodage - le type d'encodage choisi
	 */
	public Encryption(String passwordToEncrypt, Encoding encodage) {
		this.passwordToEncrypt = passwordToEncrypt;
		this.encodage = encodage.getEncoding();
		passwordEncrypted = toEncrypt();
	}

	/**
	 * Encrypt le mot de passe avec l'encodage 
	 * @return - le mot de passe encrypté avec l'encodage
	 */
	public String toEncrypt() {
		String pwd = "";
		byte[] bytes, fordigest;
		StringBuffer buf;

		try {
			md = MessageDigest.getInstance(encodage);
			bytes = passwordToEncrypt.getBytes();
			md.reset();
			fordigest = md.digest(bytes);

			buf = new StringBuffer();
			for (int i = 0; i < fordigest.length; i++) {
				buf.append(Integer.toHexString(0xff & fordigest[i]));
			}
			pwd = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return pwd;
	}

	public String getPasswordToEncrypt() {
		return passwordToEncrypt;
	}

	public void setPasswordToEncrypt(String passwordToEncrypt) {
		this.passwordToEncrypt = passwordToEncrypt;
	}

	public String getPasswordEncrypted() {
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(String passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	public String getEncodage() {
		return encodage;
	}

	public void setEncodage(String encodage) {
		this.encodage = encodage;
	}

	public static MessageDigest getMd() {
		return md;
	}

	public static void setMd(MessageDigest md) {
		Encryption.md = md;
	}

}
