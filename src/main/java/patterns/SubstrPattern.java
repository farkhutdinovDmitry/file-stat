package patterns;

public class SubstrPattern extends WordPattern {
    private final String substring;

    public SubstrPattern(String pattern) {
        this.pattern = pattern;
        substring = pattern.replace("\"", "");
    }

    @Override
    public void compareWord(String word) {
        if (word.contains(substring)) {
            counter++;
        }
    }
}
