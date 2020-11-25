package laxer;

public class Number extends AbstractTocken {
    public final int value;

    public Number(int value) {
        super(Tag.NUM);
        this.value = value;
    }

    static public AbstractTocken create(String s) {
        try {
            int i = Integer.parseInt(s);
            return new Number(i);
        } catch (NumberFormatException e) {
            return ErrorTocken.create(s);
        }
    }

    @Override
    public String toString() {
        return "< " + tag + ", " + value + " >";
    }

    public static void main(String[] args) {
        System.out.println(Number.create("12"));
    }

}
