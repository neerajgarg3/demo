package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

	private final PriceCalculator calc = new PriceCalculator();

	@Test
	void appliesDiscount() {
		assertEquals(90.0, calc.applyDiscount(100.0, 10), 0.001);
	}

	@Test
	void zeroDiscountKeepsPrice() {
		assertEquals(50.0, calc.applyDiscount(50.0, 0), 0.001);
	}

	@Test
	void rejectsInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> calc.applyDiscount(-1, 10));
		assertThrows(IllegalArgumentException.class, () -> calc.applyDiscount(10, 101));
	}
}
