package ie.com.alura.school.infra.student;

import java.util.ArrayList;
import java.util.List;

import ie.com.alura.school.domain.student.IRP;
import ie.com.alura.school.domain.student.Student;
import ie.com.alura.school.domain.student.StudentNotFound;
import ie.com.alura.school.domain.student.StudentRepository;

/**
 * StudentInMemory is a different way to implement the repository interface
 * without any changes in the domain layer. In this case, in memory.
 * 
 * @author decastrol
 *
 */
public class StudentInMemory implements StudentRepository {

	private List<Student> list = new ArrayList<>();

	@Override
	public void registerStudent(Student student) {
		this.list.add(student);
	}

	@Override
	public Student findByIRP(IRP irp) {
		return this.list.stream().filter(student -> student.getIrp().equals(irp.getNumber())).findFirst()
				.orElseThrow(() -> new StudentNotFound(irp));
	}

	@Override
	public List<Student> findAllStudent() {
		return this.list;
	}

}
