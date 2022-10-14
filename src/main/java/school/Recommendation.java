package school;

import java.time.LocalDateTime;

public class Recommendation {

	private Student indicator;
	private Student indicated;
	private LocalDateTime indicationDate;

	public Recommendation(Student indicator, Student indicated, LocalDateTime indicationDate) {
		this.indicator = indicator;
		this.indicated = indicated;
		this.indicationDate = indicationDate;
	}

	public Student getIndicator() {
		return indicator;
	}

	public Student getIndicated() {
		return indicated;
	}

	public LocalDateTime getIndicationDate() {
		return indicationDate;
	}

}
