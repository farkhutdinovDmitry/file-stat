import patterns.WordPattern;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StatCounter {
    private final static String CLASSPATH = "./files/";

    private List<WordPattern> patterns;
    private File file;
    private PatternReader patternReader;
    private PatternWriter patternWriter;

    public StatCounter(String file1, String file2, String file3) throws IOException {
        this.patternReader = new PatternReader(CLASSPATH + file2);
        this.patterns = patternReader.getPatterns();
        this.file = new File(CLASSPATH + file1);
        this.patternWriter = new PatternWriter(CLASSPATH + file3);
    }

    public void countStat() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                patterns.forEach(it -> it.compareWord(word));
            }
            patternWriter.writeResultToFile(patterns);
        } catch (IOException ex) {
            System.out.println("Error in file #1");
        }
    }
}
