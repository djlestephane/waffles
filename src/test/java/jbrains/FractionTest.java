package jbrains;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FractionTest {
    public class Fraction {
        private final int numerator;
        private final int denominator;

        public Fraction(int numerator, int denominator) {
            super();
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int numerator() {
            return numerator;
        }

        public int denominator() {
            return denominator;
        }

        @Override
        public boolean equals(Object obj) {
            return _equals(this.reduce(), ((Fraction) obj).reduce());
        }

        private boolean _equals(Fraction a, Fraction b) {
            return a.numerator == b.numerator && a.denominator == b.denominator;
        }

        public Fraction reduce() {
            int n = this.numerator;
            int d = this.denominator;
            if (d % n == 0) {
                d = d / n;
                n = 1;
            }

            return new Fraction(n, d);
        }

        public Fraction add(int i) {
            return this.add(new Fraction(i, 1));
        }

        public Fraction add(Fraction other) {
            if (this.denominator != other.denominator)
                return new Fraction(
                        this.numerator * other.denominator
                        + other.numerator * this.denominator,
                        this.denominator * other.denominator);
            
            return new Fraction(numerator + other.numerator, denominator);
        }

        public Fraction multiply(int i) {
            return new Fraction(this.numerator * i, this.denominator);
        }
    }

    @Test
    public void equals_whenComparedWithSameFraction_isEqual() {
        Fraction four = fraction(4, 1);

        assertEquals(four, four);
    }

    private Fraction fraction(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }

    @Test
    public void numerator_whenFractionIsProper_returnsNumeratorPassedAtConstructionTime() {
        Fraction f = fraction(2, 3);

        assertEquals(2, f.numerator());
    }

    @Test
    public void denominator_whenFractionIsProper_returnsDenominatorPassedAtConstructionTime() {
        Fraction f = fraction(2, 3);

        assertEquals(3, f.denominator());
    }

    @Test
    public void equals_whenComparingTwoImproperFractionsOfEqualValue_isEqual() {
        Fraction four = fraction(4, 1);
        Fraction otherFour = fraction(4, 1);

        assertEquals(four, otherFour);
    }

    @Test
    public void reduce_whenFractionIsIrreducible_returnsSelf() throws Exception {
        Fraction irreducible = fraction(1,2);

        Fraction reduced = irreducible.reduce();

        assertEquals(irreducible, reduced);
    }

    @Test
    public void reduce_whenFractionIsReducible_returnsNewEquivalentFraction() throws Exception {
        Fraction reducible = fraction(2,4);

        Fraction reduced = reducible.reduce();

        assertEquals(fraction(1,2), reduced);
    }

    @Test
    public void equals_whenComparingTwoFractionsOfEqualValueAfterReduction_isEqual() {
        Fraction oneHalf = fraction(1, 2);
        Fraction oneOtherHalf = fraction(2, 4);

        assertEquals(oneHalf, oneOtherHalf);
    }

    @Test
    public void add_whenAddingFractionsWithSameDenominator_AddsNumerators() {
        Fraction f1 = fraction(1, 3);
        Fraction f2 = fraction(2, 3);

        Fraction result = f1.add(f2);

        assertEquals(fraction(3, 3), result);
    }

    @Test
    public void add_withInteger() throws Exception {
        Fraction f1 = fraction(1, 2);

        Fraction result = f1.add(2);

        assertEquals(fraction(5, 2), result);
    }

    @Test
    public void multiply_WithInteger() throws Exception {
        Fraction f = fraction(1, 2);

        Fraction product = f.multiply(2);

        assertEquals(fraction(2, 2), product);
    }

    @Test
    public void add_whenDenominatorIsEqual() {
        Fraction four = fraction(4, 1);
        Fraction nine = fraction(9, 1);

        Fraction sum = four.add(nine);

        assertEquals(fraction(13, 1), sum);
    }

    @Test
    public void add_whenDenominatorsIsNotEqual() {
        Fraction f1 = fraction(1, 2);
        Fraction f2 = fraction(1, 3);
        
        Fraction result = f1.add(f2);
        
        assertEquals(fraction(5, 6), result);
    }
}

