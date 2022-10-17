package ie.com.alura.school.infra.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ie.com.alura.school.domain.student.Email;
import ie.com.alura.school.domain.student.IRP;
import ie.com.alura.school.domain.student.Phone;
import ie.com.alura.school.domain.student.Student;
import ie.com.alura.school.domain.student.StudentNotFound;
import ie.com.alura.school.domain.student.StudentRepository;

public class StudentRepositoryJDBC implements StudentRepository {

	private Connection connection;

	public StudentRepositoryJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void registerStudent(Student student) {
		String sql = "insert into student values(?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, student.getIrp());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.execute();

			sql = "insert into phone values(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Phone p : student.getPhones()) {
				ps.setString(1, p.getCode());
				ps.setString(2, p.getNumber());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student findByIRP(IRP irp) {
		try {
			String sql = "SELECT id, name, email FROM STUDENT WHERE irp = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, irp.getNumber());

			ResultSet rs = ps.executeQuery();
			boolean found = rs.next();
			if (!found) {
				throw new StudentNotFound(irp);
			}

			String name = rs.getString("name");
			Email email = new Email(rs.getString("email"));
			Student studentFound = new Student(irp, name, email);

			Long id = rs.getLong("id");
			sql = "SELECT code, number FROM PHONE WHERE student_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String number = rs.getString("number");
				String code = rs.getString("code");
				studentFound.addPhone(code, number);
			}

			return studentFound;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Student> findAllStudent() {
		try {
			String sql = "SELECT id, irp, name, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Student> students = new ArrayList<>();
			while (rs.next()) {
				IRP irp = new IRP(rs.getString("irp"));
				String name = rs.getString("name");
				Email email = new Email(rs.getString("email"));
				Student student = new Student(irp, name, email);

				Long id = rs.getLong("id");
				sql = "SELECT code, number FROM PHONE WHERE student_id = ?";
				PreparedStatement psPhone = connection.prepareStatement(sql);
				psPhone.setLong(1, id);
				ResultSet rsTelefone = psPhone.executeQuery();
				while (rsTelefone.next()) {
					String number = rsTelefone.getString("number");
					String code = rsTelefone.getString("code");
					student.addPhone(code, number);
				}

				students.add(student);
			}

			return students;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
