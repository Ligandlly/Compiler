package laxer;

abstract public class AbstractTocken {
    public final Tag tag;

    public AbstractTocken(Tag tag) {
        this.tag = tag;
    }

    abstract public String toString();

    static public AbstractTocken create(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return Number.create(s);
        } else if (Operator.operator_set.contains(s.charAt(0))) {
            return Operator.create(s);
        } else if (Delimit.delimit_set.contains(s.charAt(0))) {
            return Delimit.create(s);
        } else {
            return Word.create(s);
        }
    }
}
