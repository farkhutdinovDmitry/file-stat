import patterns.WordPattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PatternWriter {
    private final File file;

    public PatternWriter(String filename) {
        file = new File(filename);
    }

    public void writeResultToFile(List<WordPattern> patterns) {
        try (FileWriter fw = new FileWriter(file)) {
            for (WordPattern pattern : patterns) {
                fw.write(pattern.getPattern() + " " + pattern.getCounter() + '\n');
                fw.flush();
            }
        } catch (IOException ex) {
            System.out.println("Error in file #3");
        }
    }
}
