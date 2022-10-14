package school;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PhoneTest {

	@Test
	void shouldNotCreatePhone() {
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "123456789"));

		assertThrows(IllegalArgumentException.class, () -> new Phone("", "123456789"));

		assertThrows(IllegalArgumentException.class, () -> new Phone("1", "123456789"));
	}
	
	@Test
	void shouldCreatePhone() {
		String code = "353";
		String number = "0834363333";
		Phone p = new Phone(code, number);
		assertEquals(code, p.getCode());
		assertEquals(number, p.getNumber());
	}
}
