package laxer;

abstract public class Tocken extends AbstractTocken {
    public final String word;

    public Tocken(Tag tag, String name) {
        super(tag);
        this.word = name;
    }

    @Override
    public String toString() {
        return "< " + this.tag + ", " + word + " >";
    }

}
