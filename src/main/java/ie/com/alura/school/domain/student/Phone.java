package ie.com.alura.school.domain.student;

public class Phone {

	private String code;
	private String number;

	public Phone(String code, String number) {
		if (code == null || number == null) {
	        throw new IllegalArgumentException("Code and Number are required!");
	    }

	    if (!code.matches("\\d{3}")) {
	        throw new IllegalArgumentException("Invalid Code!");
	    }

	    if (!number.matches("\\d{9}|\\d{10}")) {
	        throw new IllegalArgumentException("Invalid Number!");
	    }
		this.code = code;
		this.number = number;
	}

	public String getCode() {
		return code;
	}

	public String getNumber() {
		return number;
	}

}
