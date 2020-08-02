import exceptions.IncorrectPatternException;
import patterns.LetterPattern;
import patterns.SubstrPattern;
import patterns.WordPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PatternReader {
    private final File file;

    public PatternReader(String filename) {
        file = new File(filename);
    }

    public List<WordPattern> getPatterns() throws IOException {
        Pattern letterPattern = Pattern.compile("(.\\d)+");
        Pattern substrPattern = Pattern.compile("\"(.)+\"");
        List<WordPattern> patterns = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                if (letterPattern.matcher(line).matches()) {
                    patterns.add(new LetterPattern(line));
                } else if (substrPattern.matcher(line).matches()) {
                    patterns.add(new SubstrPattern(line));
                } else {
                    throw new IncorrectPatternException("Incorrect pattern: " + line);
                }
                line = reader.readLine();
            }
        }
        return patterns;
    }
}
