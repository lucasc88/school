package ie.com.alura.school.application.student.register;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ie.com.alura.school.domain.student.IRP;
import ie.com.alura.school.domain.student.Student;
import ie.com.alura.school.infra.student.StudentInMemory;

class RegisterStudentTest {

	@Test
	void shouldBePersisted() {
		StudentInMemory studentInMemory = new StudentInMemory();
		RegisterStudent r = new RegisterStudent(studentInMemory);
		RegisterStudentDTO dados = new RegisterStudentDTO("Fulano", "123.456.789-00", "fulano@email.com");
		r.registerStudent(dados);
	
		Student studentFound = studentInMemory.findByIRP(new IRP("123.456.789-00"));
		
		assertEquals("Fulano", studentFound.getName());
		assertEquals("123.456.789-00", studentFound.getIrp());
		assertEquals("fulano@email.com", studentFound.getEmail());
	}

}
