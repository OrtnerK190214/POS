public class RationalCalculator extends AbstractCalculator {

    public RationalCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, subtract, multiply, divide);
    }

    @Override
    public Number add(Number a, Number b) {
        double tmp = a.getA() * a.getB() + b.getA() * b.getB();
        return null;
    }

    @Override
    public Number subtract(Number a, Number b) {
        double tmp = a.getA() * a.getB() - b.getA() * b.getB();
        return null;
    }

    @Override
    public Number multiply(Number a, Number b) {
        double tmp = a.getA() * a.getB() * b.getA() * b.getB();
        return null;
    }

    @Override
    public Number divide(Number a, Number b) {
        double tmp = a.getA() * a.getB() / b.getA() * b.getB();
        return null;
    }
}
