public class Divide extends Binop {
    @Override
    public double eval(double left, double right) { return right == 0 ? Double.POSITIVE_INFINITY : left / right; }
    @Override
    public String toString() { return "/"; }
}