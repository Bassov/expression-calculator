package parser;

import collection.list.LinkedList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private LinkedList<String> tokens;

    public Tokenizer(String tokens) {
        this.tokens = splitString(tokens);
    }

    public String peek() {
        if (tokens.isEmpty()) {
            return "Null";
        }
        return tokens.first();
    }

    public String pop() {
        return tokens.removeFirst();
    }

    private static LinkedList<String> splitString(String input) {
        Pattern p = Pattern.compile("-\\d+|\\d+|[-+*()]|xor|or|and|<=|>=|/=|[<>=/]");
        Matcher m = p.matcher(input);

        LinkedList<String> result = new LinkedList<>();
        while (m.find()) {
            result.addLast(m.group(0));
        }
        return result;
    }

}
