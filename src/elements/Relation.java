package elements;

public class Relation extends Expression {

    public enum Opcode {
        less, less_eq, greater, greater_eq, equal, not_eq, none
    }

    private Opcode op;

    public Relation(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public static Opcode parseOperator(String op) {
        switch (op) {
            case "<":
                return Opcode.less;
            case "<=":
                return Opcode.less_eq;
            case ">":
                return Opcode.greater;
            case ">=":
                return Opcode.greater_eq;
            case "=":
                return Opcode.equal;
            case "/=":
                return Opcode.not_eq;
            default:
                return Opcode.none;
        }
    }

    @Override
    public int calculate() {
        int left = this.left.calculate();
        int right = this.right.calculate();

        switch (op) {
            case less:
                return (left < right) ? 1 : 0;
            case less_eq:
                return (left <= right) ? 1 : 0;
            case greater:
                return (left > right) ? 1 : 0;
            case greater_eq:
                return (left >= right) ? 1 : 0;
            case equal:
                return (left == right) ? 1 : 0;
            case not_eq:
                return (left != right) ? 1 : 0;
            default:
                System.err.println("Wrong expression::Relation");
                return 0;
        }
    }

    @Override
    protected String getOp() {
        return op.name();
    }

}