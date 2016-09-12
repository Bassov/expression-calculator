package elements;

public class Integer extends Primary {

    private int value;

    public Integer(String value) {
        this.value = parseInteger(value);
    }

    private static int parseInteger(String op) {
        int i = 0;
        int num = 0;

        while(i < op.length()) {
            num *= 10;
            num += op.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
        }

        return num;
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public String toJSON() {
        return value + "";
    }

    @Override
    protected String getOp() {
        return null;
    }

}
