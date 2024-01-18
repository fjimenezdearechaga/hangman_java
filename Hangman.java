import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        String word = randomWord();
        char[] letters = word.toCharArray();
        char[] board = board(letters);
        String misses = "Misses:  ";

        int iterator = 0;
        boolean noWinner = true;
        while(noWinner && iterator<7){
            System.out.println(gallows[iterator]);
            printBoard(board);
            System.out.println(misses);
            char letter = pickLetter();
            boolean letterNotFound = checkLetter(letter, letters, board);
            if (letterNotFound){
                misses = misses + letter;
                iterator++;
            }else{
                noWinner = checkWinner(board);
            }

        }
        if(noWinner){
            System.out.println("You lose...");
            System.out.println("Word: " +word);
        }else{
            System.out.println("You win!!!!");
            System.out.println("Word: " + word);
        }
    }

    public static String randomWord(){
        Random rand = new Random();
        int number = rand.nextInt(words.length - 1);
        return words[number];
    }

    public static char pickLetter(){
        System.out.print("Pick a letter: ");
        char letter = scan.nextLine().charAt(0);
        return letter;
    }

    public static boolean checkLetter(char letter, char[] letters,char[]board){
        char currentLetter = ' ';
        boolean notFound = true;
        for(int i = 0; i<letters.length; i++){
            currentLetter = letters[i];
            if(currentLetter == letter){
                board[i] = currentLetter;
                notFound = false;
            }
        }
        return notFound;
    }

    public static char[] board(char[] letters){
        char[] board = new char[letters.length];
        for(int i=0;i<board.length;i++){
            board[i] = '_';
        }
        return board;
    }
    public static void printBoard(char[] board){
        for(int i = 0; i<board.length;i++){
            System.out.print(board[i] + " ");
        }
        System.out.println(" ");
    }

    public static boolean checkWinner(char[] letters){
        boolean noWinner = false;
        for(int i=0; i<letters.length;i++){
            if(letters[i]=='_'){
                noWinner = true;
            }
        }
        return noWinner;
    }

}





