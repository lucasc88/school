package ie.com.alura.school.domain.student;

public class StudentNotFound extends RuntimeException {

	private static final long serialVersionUID = -1371506389629919655L;
	
	public StudentNotFound(IRP irp) {
		super("Student not found. IRP: " + irp.getNumber());
	}

}
