package ie.com.alura.school.application.student.register;

import ie.com.alura.school.domain.student.Email;
import ie.com.alura.school.domain.student.IRP;
import ie.com.alura.school.domain.student.Student;

public class RegisterStudentDTO {

	private String name;
	private String irp;
	private String email;

	public RegisterStudentDTO(String name, String irp, String email) {
		this.name = name;
		this.irp = irp;
		this.email = email;
	}

	public Student studentCreation() {
		Student s = new Student(new IRP(irp), name, new Email(email));
		return s;
	}
}
