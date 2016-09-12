package elements;

public class Factor extends Expression {

    public enum Opcode {
        multiplication, division, none
    }

    private Opcode op;

    public Factor(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public static Opcode parseOperator(String op) {
        switch (op) {
            case "*":
                return Opcode.multiplication;
            case "/":
                return Opcode.division;
            default:
                return Opcode.none;
        }
    }

    @Override
    public int calculate() {
        int left = this.left.calculate();
        int right = this.right.calculate();

        switch (op) {
            case multiplication:
                return left * right;
            case division:
                return left / right;
            default:
                System.err.println("Wrong expression::Factor");
                return 0;
        }
    }

    @Override
    protected String getOp() {
        return op.name();
    }

}
