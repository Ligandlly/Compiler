package laxer;

import java.util.HashSet;
import java.util.Set;

public class Operator extends Tocken {

    static public Set<Character> operator_set = new HashSet<>();
    static {
        operator_set.add('!');
        operator_set.add('<');
        operator_set.add('>');
        operator_set.add('=');
        operator_set.add('+');
    }

    public Operator(Tag tag, String name) {
        super(tag, name);
    }

    static public AbstractTocken create(String s) {
        if (s.length() > 2) {
            return ErrorTocken.create(s);
        }
        switch (s.charAt(0)) {
            case '>': {
                if (s.length() == 1)
                    return new Operator(Tag.GT, s);
                if (s.charAt(1) == '=')
                    return new Operator(Tag.GE, s);
                return ErrorTocken.create(s);
            }
            case '=': {
                if (s.length() == 1)
                    return new Operator(Tag.AS, s);
                if (s.charAt(1) == '=')
                    return new Operator(Tag.EQ, s);
                return ErrorTocken.create(s);
            }
            case '<': {
                if (s.length() == 1)
                    return new Operator(Tag.LT, s);
                if (s.charAt(1) == '=')
                    return new Operator(Tag.LE, s);
                return ErrorTocken.create(s);
            }
            case '!': {
                if (s.equals("!="))
                    return new Operator(Tag.NE, s);
                return ErrorTocken.create(s);
            }
            case '+': {
                if (s.length() == 1)
                    return new Operator(Tag.ADD, s);
                else
                    return new ErrorTocken(s);
            }
        }
        return ErrorTocken.create(s);
    }

    public static void main(String[] args) {
        System.out.println(create("=2"));
    }
}
