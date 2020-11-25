package laxer;

public abstract class Word extends Tocken {

    public Word(Tag tag, String name) {
        super(tag, name);
    }

    public static Word create(String s) {
        if (Keyword.keyword_set.contains(s)) {
            return Keyword.create(s);
        } else {
            return ID.create(s);
        }
    }
    
}
