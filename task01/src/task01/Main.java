package task01;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console con = System.console();
        String input = "";

        while(!input.equals("exit")) {
            input = con.readLine().trim().toLowerCase();
            String[] inputArr = input.split(" ");

            if (inputArr.length == 3) {
                float number1 = AnswerStorageHandler.parsePlaceholder(inputArr[0].trim());
                float number2 = AnswerStorageHandler.parsePlaceholder(inputArr[2].trim());
                String operator = inputArr[1].trim();
                
                switch(operator) {
                    case "+":
                        AnswerStorageHandler.storedAns = number1 + number2;
                        System.out.println(AnswerStorageHandler.storedAns);
                        break;
                    case "-":
                        AnswerStorageHandler.storedAns = number1 - number2;
                        System.out.println(AnswerStorageHandler.storedAns);
                        break;
                    case "/":
                        AnswerStorageHandler.storedAns = number1 / number2;
                        System.out.println(AnswerStorageHandler.storedAns);
                        break;
                    case "*":
                        AnswerStorageHandler.storedAns = number1 * number2;
                        System.out.println(AnswerStorageHandler.storedAns);
                        break;
                }
            }
        }
        System.out.println("Bye bye");
        System.exit(0);
    }
}
