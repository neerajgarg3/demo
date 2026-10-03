package com.example.demo;

public class PriceCalculator {

	public double applyDiscount(double price, int percent) {
		if (price < 0 || percent < 0 || percent > 100) {
			throw new IllegalArgumentException("Invalid input");
		}
		return price - (price * percent / 100.0);
	}
}
