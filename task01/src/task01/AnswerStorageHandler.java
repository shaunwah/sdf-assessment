package task01;

public class AnswerStorageHandler {
    public static final String PLACEHOLDER = "$last";
    public static Float storedAns = 0.0f;

    static Float parsePlaceholder(String str) {
        if (str.contains(PLACEHOLDER)) {
            return storedAns;
        }
        return Float.parseFloat(str);
    }
}
