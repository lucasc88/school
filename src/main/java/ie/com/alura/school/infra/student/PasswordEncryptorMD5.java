package ie.com.alura.school.infra.student;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import ie.com.alura.school.domain.student.PasswordEncryptor;

/**
 * Class responsible for implementing encryption. It's a structure layer class.
 * 
 * @author decastrol
 *
 */
public class PasswordEncryptorMD5 implements PasswordEncryptor {

	@Override
	public String encryptorPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error during the password encryptor");
		}
	}

	@Override
	public boolean checkPassword(String passwordEncrypted, String normalPassword) {
		return passwordEncrypted.equals(encryptorPassword(normalPassword));
	}

}
