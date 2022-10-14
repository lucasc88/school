package school;

public class IRP {

	private String number;

	public IRP(String number) {
		if (number == null || !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("Invalid IRP!");
		}
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

}
