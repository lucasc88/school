package ie.com.alura.school.application.recommendation;

import ie.com.alura.school.domain.student.Student;

public interface SendEmail {

	void sendEmail(Student indicated);
}
