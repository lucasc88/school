package ie.com.alura.school.domain.student;

/**
 * This class is not an Entity because there is no attribute to identify a
 * unique email. This class is a Value Object Class
 * 
 * @author decastrol
 *
 */
public class Email {

	private String address;

	public Email(String address) {
		if (address == null || !address.matches("^(.+)@(.+)$")) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

}
