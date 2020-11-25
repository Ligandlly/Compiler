package laxer;

import java.util.HashSet;
import java.util.Set;

public class Delimit extends Tocken {
    public static Set<Character> delimit_set;

    static {
        delimit_set = new HashSet<>();
        delimit_set.add('(');
        delimit_set.add(')');
        delimit_set.add('[');
        delimit_set.add(']');
        delimit_set.add('{');
        delimit_set.add('}');
        delimit_set.add(';');
    }

    public Delimit(Tag tag, String name) {
        super(tag, name);
    }

    public static Tocken create(String s) {
        switch (s.charAt(0)) {
            case '(':
                return new Delimit(Tag.LP, s);
            case ')':
                return new Delimit(Tag.RP, s);
            case '[':
                return new Delimit(Tag.LBT, s);
            case ']':
                return new Delimit(Tag.RBT, s);
            case '{':
                return new Delimit(Tag.LBS, s);
            case '}':
                return new Delimit(Tag.RBS, s);
            case ';':
                return new Delimit(Tag.SEM, s);
            default:
                return new ErrorTocken(s);
        }
    }

}
