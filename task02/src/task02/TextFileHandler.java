package task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class TextFileHandler {
    private File file;
    private Map<String, Map<String, Integer>> wordMap = new HashMap<>();
    private List<String> wordList = new ArrayList<>();

    public TextFileHandler(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Map<String, Map<String, Integer>> getWordMap() {
        return wordMap;
    }

    public void setWordMap(Map<String, Map<String, Integer>> wordMap) {
        this.wordMap = wordMap;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public void readFiles() throws FileNotFoundException, IOException {
        if (getFile().isFile()) {
            readFile();
        } else {
            File[] files = getFile().listFiles();
            for (File file: files) {
                setFile(file);
                readFiles();
            }
        }
    }
    
    public void readFile() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(getFile());
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            String sanitisedLine = line.trim().toLowerCase().replaceAll("\\p{P}", "");
            String[] words = sanitisedLine.split(" ");

            for (String word: words) {
                getWordList().add(word.trim());
                getWordMap().put(word, Map.of());
            }

        }

        for (int i = 0; i < getWordList().size() - 1; i++) {
            String current = getWordList().get(i);
            String next = getWordList().get(i + 1);

            if (getWordMap().containsKey(current)) {
                Map<String, Integer> subWordMap = new HashMap<>(wordMap.get(current));
                if (!next.isBlank()) {
                    if (subWordMap.containsKey(next)) {
                        subWordMap.put(next, subWordMap.get(next) + 1);
                        getWordMap().put(current, subWordMap);
                    } else {
                        subWordMap.put(next, 1);
                        getWordMap().put(current, subWordMap);
                    }
                } else {
                    getWordMap().remove(current);
                }
            }
        }
        fr.close();
    }
    
    public void printFileToConsole() {
        for (var main: getWordMap().entrySet()) {
            int sum = 0;
            System.out.println(main.getKey());
            Set<Entry<String, Integer>> set = main.getValue().entrySet();
            for (var sub: set) {
                sum += sub.getValue();
            }
            for (var sub: set) {
                System.out.printf("    %s %.2f\n", sub.getKey(), (float) sub.getValue() / sum);
            }
        }
    }
}
