package elements;

public class Integer extends Primary {

    private int value;

    public Integer(String value) {
        this.value = parseInteger(value);
    }

    private static int parseInteger(String str) {
        int i = 0;
        int num = 0;
        boolean isNeg = false;

        if (str.charAt(0) == '-') {
            isNeg = true;
            i = 1;
        }

        while( i < str.length()) {
            num *= 10;
            num += str.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
        }

        return isNeg ? -num : num;
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
