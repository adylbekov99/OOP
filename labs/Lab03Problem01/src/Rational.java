public class Rational {
    // State
    private int numerator;
    private int denominator;

    // Behaviour
    Rational(int numerator, int denominator) {
        if(denominator == 0){
            throw new ArithmeticException("Incorrect rational: Denominator can't be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Rational add(Rational another) {
        return new Rational(
                numerator * another.denominator + denominator * another.denominator,
                denominator * another.denominator);
    }

    Rational sub(Rational another) {
        return new Rational(
                numerator * another.denominator - denominator * another.denominator,
                denominator * another.denominator);
    }

    Rational mul(Rational another) {
        return new Rational(
                numerator * another.numerator,
                denominator * another.denominator);
    }
    Rational div(Rational another) {
        return new Rational(
                numerator * another.denominator,
                denominator * another.numerator);
    }
    int compareTo(Rational other){
        int a = numerator * other.denominator;
        int b = denominator * other.numerator;

        return a - b;
    }

    public String toString() {
        return numerator  + "/" + denominator;
    }

    static Rational parse(String input) {
        String[] parts = input.split("/");
        if(parts.length == 0 || parts.length > 2) {
            throw new IllegalArgumentException("Incorrect rational: " + input);
        }
        Rational rational = null;
        try {
            if(parts.length == 1){
                int numerator = Integer.parseInt(input);
                return new Rational(numerator, numerator);
            } else {
                int numerator = Integer.parseInt(parts[0]);
                int denominator = Integer.parseInt(parts[1]);
                return new Rational(numerator, denominator);
            }
        } catch(NumberFormatException e){
            throw new NumberFormatException("Incorrect rational: " + input);
        }
    }
}
