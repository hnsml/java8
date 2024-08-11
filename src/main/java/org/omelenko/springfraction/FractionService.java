package org.omelenko.springfraction;

import org.springframework.stereotype.Service;

@Service
public class FractionService {
    public boolean isValidFraction(Fraction fraction) {
        return fraction != null && fraction.isValid();
    }

    public boolean isIdenticalDenominator(Fraction fraction1, Fraction fraction2) {
        return fraction1.getDenominator() == fraction2.getDenominator();
    }

    public Fraction reduceFraction(Fraction fraction) {
        Fraction result = fraction;
        int less = Math.min(result.getNumerator(), result.getDenominator());
        for (int i = 2; i < less; i++) {
            if(result.getNumerator() % i == 0 &&  result.getDenominator() % i == 0) {
                result = new Fraction(fraction.getNumerator()/i, fraction.getDenominator()/i);
                return reduceFraction(result);
            }
        }
        return result;
    }

    public Fraction addFractions(Fraction fraction1, Fraction fraction2) {
        return Fraction.add(fraction1, fraction2);
    }

    public Fraction subtractFractions(Fraction fraction1, Fraction fraction2) {
        return Fraction.subtract(fraction1, fraction2);
    }

    public Fraction multiplyFractions(Fraction fraction1, Fraction fraction2) {
        return Fraction.multiply(fraction1, fraction2);
    }

    public Fraction divideFractions(Fraction fraction1, Fraction fraction2) {
        return Fraction.divide(fraction1, fraction2);
    }
}
