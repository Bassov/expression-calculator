package parser;

import elements.*;
import elements.Integer;

public class Parser {

    private Tokenizer input;

    public Parser(String input) {
        this.input = new Tokenizer(input);
    }

    public Expression parse() {
        return parseLogical();
    }

    private Expression parseLogical() {
        Expression result = parseRelational();
        while (true) {
            Logical.Opcode op = Logical.parseOperator(input.peek());
            if (op != Logical.Opcode.none) {
                input.pop();
                Expression right = parseRelational();
                result = new Logical(op, result, right);
            } else {
                break;
            }
        }
        return result;
    }

    private Expression parseRelational() {
        Expression result = parseTerm();
        Relation.Opcode op = Relation.parseOperator(input.peek());
        if (op != Relation.Opcode.none) {
            input.pop();
            Expression right = parseTerm();
            result = new Relation(op, result, right);
        }
        return result;
    }

    private Expression parseTerm() {
        Expression result = parseFactor();
        while (true) {
            Term.Opcode op = Term.parseOperator(input.peek());
            if (op != Term.Opcode.none) {
                input.pop();
                Expression right = parseFactor();
                result = new Term(op, result, right);
            } else {
                break;
            }
        }
        return result;
    }

    private Expression parseFactor() {
        Expression result = parsePrimary();
        while (true) {
            Factor.Opcode op = Factor.parseOperator(input.peek());
            if (op != Factor.Opcode.none) {
                input.pop();
                Expression right = parsePrimary();
                result = new Factor(op, result, right);
            } else {
                break;
            }
        }
        return result;
    }

    private Expression parsePrimary() {
        Expression result = null;
        if (input.peek().matches("\\d+")) {
            result = new Integer(input.pop());
        } else if (input.peek().equals("(")) {
            input.pop(); // to pop "("
            result = parse();
            input.pop(); // to pop ")"
        } else {
            System.err.println("Error::ParsePrimary");
        }
        return result;
    }

}
