package elements;

public abstract class Expression {

    protected Expression left, right;

    public abstract int calculate();

    public String toJSON() {
        String left = this.left.toJSON();
        String right = this.right.toJSON();

        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"operator\" : ")
                .append("\"").append(getOp()).append("\", ")
                .append("\"left\" : ")
                .append(left).append(", ")
                .append("\"right\" : ")
                .append(right).append("}");

        return sb.toString();
    }

    protected abstract String getOp();

}
