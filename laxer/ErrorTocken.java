package laxer;

public class ErrorTocken extends Tocken {

    public ErrorTocken(String name) {
        super(Tag.ERROR, name);
    }

    static public AbstractTocken create(String word) {
        return new ErrorTocken(word);
    }

}
