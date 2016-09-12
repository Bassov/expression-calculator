import elements.Expression;
import parser.Parser;

public class Main {

    public static void main(String[] args) {
        String input = "(5 or 10 xor 1) > 10 - 2 * 2";
        Parser parser = new Parser(input);
        Expression tree = parser.parse();

        System.out.println("expression: " + input);
        System.out.println("result = " + tree.calculate());
        System.out.println("expression in JSON: " + tree.toJSON());
    }

}
