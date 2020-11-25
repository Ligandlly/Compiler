package laxer;

import java.util.HashSet;
import java.util.Set;

public class Keyword extends Word {

    static public Set<String> keyword_set = new HashSet<>();
    static {
        keyword_set.add("if");
        keyword_set.add("else");
        keyword_set.add("return");
        keyword_set.add("int");
    }

    public Keyword(Tag tag, String name) {
        super(tag, name);
    }

    static public Keyword create(String s) {
        return new Keyword(Tag.valueOf(s.toUpperCase()), s);
    }

    public static void main(String[] args) {
        System.out.println(create("if"));
    }

}
