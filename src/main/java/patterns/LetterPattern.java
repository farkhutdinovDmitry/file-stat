package patterns;

import java.util.HashMap;
import java.util.Map;

public class LetterPattern extends WordPattern {
    private HashMap<Character, Integer> letterMap;

    public LetterPattern(String pattern) {
        this.pattern = pattern;
        this.counter = 0;
        this.letterMap = new HashMap<>();
        char[] symbols = pattern.toCharArray();
        for (int i = 0; i < symbols.length; i += 2) {
            letterMap.put(symbols[i], symbols[i + 1] - '0');
        }
    }

    @Override
    public void compareWord(String word) {
        if (matches(word)) {
            counter++;
        }
    }

    private boolean matches(String word) {
        char[] symbols = word.toCharArray();
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (char symbol : symbols) {
            if (strMap.containsKey(symbol)) {
                strMap.compute(symbol, (k, v) -> v + 1);
            } else {
                strMap.put(symbol, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : letterMap.entrySet()) {
            Character key = entry.getKey();
            if (strMap.containsKey(key)) {
                if (strMap.get(key) < entry.getValue()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
