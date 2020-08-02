package patterns;

public abstract class WordPattern {
    protected String pattern;
    protected int counter;

    public abstract void compareWord(String string);

    public String getPattern() {
        return pattern;
    }

    public int getCounter() {
        return counter;
    }
}
