package org.omelenko.springfraction;

public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public boolean isValid() {
        return denominator != 0;
    }

    public static Fraction add(Fraction fraction1, Fraction fraction2) {
        int commonDenominator = fraction1.denominator * fraction2.denominator;
        int newNumerator = fraction1.numerator * fraction2.denominator + fraction2.numerator;
        return new Fraction(newNumerator, commonDenominator);
    }

    public static Fraction subtract(Fraction fraction1, Fraction fraction2) {
        int commonDenominator = fraction1.denominator * fraction2.denominator;
        int newNumerator = fraction1.numerator * fraction2.denominator - fraction2.numerator;
        return new Fraction(newNumerator, commonDenominator);
    }

    public static Fraction multiply(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.numerator;
        int newDenominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction divide(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.denominator;
        int newDenominator = fraction1.denominator * fraction2.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
}
