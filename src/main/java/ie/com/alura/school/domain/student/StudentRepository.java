package ie.com.alura.school.domain.student;

import java.util.List;

/**
 * Interface responsible to keep the domain free of the technical details about
 * the DB. In case of DB change, the domain layer will not be affected
 * 
 * @author decastrol
 *
 */
public interface StudentRepository {

	void registerStudent(Student student);

	Student findByIRP(IRP irp);

	List<Student> findAllStudent();
}
