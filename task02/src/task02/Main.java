package task02;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("No directory specified!");
            System.exit(0);
        }

        File file = new File(args[0]);
        TextFileHandler textFileHandler = new TextFileHandler(file);
        textFileHandler.readFiles();
        textFileHandler.printFileToConsole();
    }
}
