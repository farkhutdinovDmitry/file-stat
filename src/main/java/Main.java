import exceptions.IncorrectPatternException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Bad input");
            return;
        }
        try {
            StatCounter counter = new StatCounter(args[0], args[1], args[2]);
            counter.countStat();
        } catch (IncorrectPatternException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error in file #2");
            ex.printStackTrace();
        }
    }
}
