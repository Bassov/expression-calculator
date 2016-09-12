package elements;

public class Term extends Expression {

    public enum Opcode {
        plus, minus, none
    }

    private Opcode op;

    public Term(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public static Opcode parseOperator(String op) {
        switch (op) {
            case "+":
                return Opcode.plus;
            case "-":
                return Opcode.minus;
            default:
                return Opcode.none;
        }
    }

    @Override
    public int calculate() {
        int left = this.left.calculate();
        int right = this.right.calculate();

        switch (op) {
            case plus:
                return left + right;
            case minus:
                return left - right;
            default:
                System.err.println("Wrong expression::Term");
                return 0;
        }
    }

    @Override
    protected String getOp() {
        return op.name();
    }

}
