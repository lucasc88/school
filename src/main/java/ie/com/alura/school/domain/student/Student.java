package ie.com.alura.school.domain.student;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an Entity because there is a attribute (irp) to identify an
 * unique person
 * 
 * @author decastrol
 *
 */
public class Student {

//	private Long id; it's part of the infrastructure, it's not the domain of the application.
//	The Domain must be totally uncoupled, independent of the infrastructure
	private IRP irp;
	private String name;
	private Email email;

	private List<Phone> phones = new ArrayList<>();
	
	public Student(IRP irp, String name, Email email) {
		this.irp = irp;
		this.name = name;
		this.email = email;
	}

	public void addPhone(String code, String number) {
		this.phones.add(new Phone(code, number));
	}

	public String getIrp() {
		return irp.getNumber();
	}

	public void setIrp(IRP irp) {
		this.irp = irp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email.getAddress();
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Student IRP: " + irp + ", name=" + name + ", email=" + email + ", phones=" + phones;
	}
	
	
}
