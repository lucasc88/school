package ie.com.alura.school.application.student.register;

import ie.com.alura.school.domain.student.Student;
import ie.com.alura.school.domain.student.StudentRepository;

public class RegisterStudent {

	private final StudentRepository studentRepository;

	public RegisterStudent(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public void registerStudent(RegisterStudentDTO studentDTO) {
		Student newStudent = studentDTO.studentCreation();
		studentRepository.registerStudent(newStudent);
	}
}
