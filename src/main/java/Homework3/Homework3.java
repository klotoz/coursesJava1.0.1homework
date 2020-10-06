package Homework3;


import java.util.Random;
import java.util.Scanner;


public class Homework3 {

    static  Scanner s = new Scanner(System.in);
    static  Scanner sc = new Scanner(System.in);
    static  Scanner sca = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        choiceGame();

    }
/**
 * Игра угадай число от 0 до bound
 * */
    private static void guessingGame() {
        int answer = random.nextInt(10);


        System.out.println("Угадай число от 0 до 10. У вас 3 попытки");

        int count = 3;

        for(int tryCount = 1; tryCount <= count; tryCount++){
            int userAnswer = sc.nextInt();
            if (userAnswer == answer){
                System.out.println("Поздравляю, вы угадали!");
                break;
            } else if (tryCount == count){
                System.out.println("Попытки закончились");

            } else  if (userAnswer > answer){
                System.out.println("Ваше число больше загаданного. Попробуйте еще");

            } else  if (userAnswer < answer){
                    System.out.println("Ваше число меньше загаданного. Попробуйте еще");
        }

        }
        System.out.println("Загаданное число " + answer);
        contGame();

    }

    private static void guessingWords(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};


        String answer = getRandomWord(words);
        String maskedAnswer = disguise(answer);
        System.out.println("Угадайте, какой фрукт или овощ мы загадали. Ответ вводите на английском языке");


        while (true){
        String userAnswer = sca.nextLine();
        userAnswer = disguise(userAnswer);
            if (maskedAnswer.equals(userAnswer)){
                System.out.println("Поздравляю, вы угадали!");
                break;
            } else {
                String hint = "";
                for (int i = 0; i < maskedAnswer.length()-1; i++) {
                    if (maskedAnswer.charAt(i) == userAnswer.charAt(i)){
                        hint += maskedAnswer.charAt(i);
                    } else {
                        hint += "#";
                    }
                }
                System.out.println("Посмотрите, какие буквы вы угадали: " + hint);
                System.out.println("Попробуйте еще!");
            }
        }


        contGame();

    }

    private static String getRandomWord(String[] s){
        Random r = new Random();
        return s[r.nextInt(s.length - 1)];
    }

    private static String disguise (String s){
        String mask = "################";
        for (int i = s.length(); i < mask.length(); i++){
            s += mask.charAt(i);
        }
        return s;
    }

    private static void choiceGame(){
        System.out.println("В какую игру вы хотите сыграть?\nЕсли хотите поугадывать числа, введите Ч, если слова, введите Б");
        String choice = s.nextLine().toLowerCase();

        if (choice.equals("ч")){
            guessingGame();
        } else if (choice.equals("б")){
            guessingWords();
        } else {
            System.out.println("Ну и не будем играть!");

        }

    }
    private static void contGame(){
        System.out.println("Хотите сыграть еще? Если да, введите 1, если нет, 0");
        int userAnswer = sc.nextInt();
        if (userAnswer == 1 ){
            choiceGame();
        } else if (userAnswer == 0){
            System.out.println("До скорой встречи!");
            }

    }
}
