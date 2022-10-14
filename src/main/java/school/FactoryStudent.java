package school;

/**
 * Class to create student and phones. It has a builder behaviour.
 * 
 * @author decastrol
 *
 */
public class FactoryStudent {

	private Student student;

	/**
	 * Method to let easier the student object creation
	 * 
	 * @param irp
	 * @param name
	 * @param email
	 * @return this to chain objects creation
	 */
	public FactoryStudent creationWithIrpNameEmail(String irp, String name, String email) {
		this.student = new Student(new IRP(irp), name, new Email(email));
		return this;
	}

	/**
	 * Method to let easier the phone object creation
	 * 
	 * @param code
	 * @param number
	 * @return this to chain objects creation
	 */
	public FactoryStudent creationPhone(String code, String number) {
		this.student.addPhone(code, number);
		return this;
	}

	public Student create() {
		return this.student;
	}

	// example of use
	public static void main(String... args) {
		FactoryStudent factory = new FactoryStudent();
		Student student = factory.creationWithIrpNameEmail("123.123.123-12", "Lucas", "lucas@lucas.com")
				.creationPhone("353", "0834333332").create();
		System.out.println(student);
	}
}
