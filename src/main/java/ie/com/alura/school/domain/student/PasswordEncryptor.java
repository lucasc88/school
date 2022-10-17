package ie.com.alura.school.domain.student;

/**
 * Interface responsible to determines password encryptor methods. It's a domain
 * layer but its implementation is an infrastructure layer.
 * 
 * @author decastrol
 *
 */
public interface PasswordEncryptor {

	String encryptorPassword(String password);

	boolean checkPassword(String passwordEncrypted, String normalPassword);
}
