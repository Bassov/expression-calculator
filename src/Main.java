import elements.Expression;
import parser.Parser;

public class Main {

    public static void main(String[] args) {
        String input = "((5 or 10 xor 1) < 10 - 2 * 2) +-2 - -4";
        Parser parser = new Parser(input);
        Expression tree = parser.parse();

        FileHelper fileHelper = new FileHelper();
        fileHelper.write(tree.toJSON(), "tree.json");

        System.out.println("expression: " + input);
        System.out.println("result = " + tree.calculate());
        System.out.println("expression in JSON is in the output file");
    }

}
