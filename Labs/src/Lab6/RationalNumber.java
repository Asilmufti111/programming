
public class RationalNumber {

    private int numerator;
    private int denominator;

    public RationalNumber(int numer, int denom) {
        this.numerator = numer;
        this.denominator = denom;
    }

    public RationalNumber add(RationalNumber op2) {
        int numer = (this.numerator * op2.denominator) + this.denominator * op2.numerator;
        int denom = this.denominator * op2.denominator;
        RationalNumber result = new RationalNumber(numer, denom);
        return result;
    }

    public RationalNumber multiply(RationalNumber op2) {
        int numer = this.numerator * op2.numerator;
        int denom = this.denominator * op2.denominator;
        RationalNumber result = new RationalNumber(numer, denom);
        return result;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
