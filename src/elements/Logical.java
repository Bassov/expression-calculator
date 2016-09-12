package elements;

public class Logical extends Expression {

    public enum Opcode {
        and, or, xor, none
    }

    private Opcode op;

    public Logical(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public static Opcode parseOperator(String op) {
        switch (op) {
            case "and":
                return Opcode.and;
            case "or":
                return Opcode.or;
            case "xor":
                return Opcode.xor;
            default:
                return Opcode.none;
        }
    }

    @Override
    public int calculate() {
        int left = this.left.calculate();
        int right = this.right.calculate();

        switch (op) {
            case and:
                return (left > 0 && right > 0) ? 1 : 0;
            case or:
                return (left > 0 || right > 0) ? 1 : 0;
            case xor:
                return ((left > 0 && right == 0) || (left == 0 && right > 0)) ? 1 : 0;
            default:
                System.err.println("Wrong expression::Logical");
                return 0;
        }
    }

    @Override
    protected String getOp() {
        return op.name();
    }

}
