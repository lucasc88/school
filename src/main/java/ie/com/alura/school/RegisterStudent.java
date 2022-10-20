package ie.com.alura.school;

import ie.com.alura.school.domain.student.Email;
import ie.com.alura.school.domain.student.IRP;
import ie.com.alura.school.domain.student.Student;
import ie.com.alura.school.infra.student.StudentInMemory;

public class RegisterStudent {

	public static void maind(String[] strings) {
		String name = "Lucas";
		IRP irp = new IRP("123.456.789-00");
        Email email = new Email ("fulano@email.com");

        Student student = new Student(irp, name, email);
        StudentInMemory memory = new StudentInMemory();
        memory.registerStudent(student);
	}
}
