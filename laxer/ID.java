package laxer;

public class ID extends Word {

    public ID(String name) {
        super(Tag.ID, name);
    }

    static public ID create(String s) {
        return new ID(s);
    }

}
