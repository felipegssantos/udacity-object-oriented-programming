import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        System.out.println("Let the game begin!");
        Game game = new Game();
        System.out.println(game.getCurrentName());

        char[] guesses = {'e', 'a', 'a', 'c'};
        boolean keepPlaying = true;
        Scanner keyboard = new Scanner(System.in);
        while (keepPlaying) {
            System.out.println("Please type a single letter and press enter.");
            String input = keyboard.nextLine();
            if (input.length() != 1) {
                continue;
            }
            char guess = input.charAt(0);

            if (game.analyzeGuess(guess)) {
                System.out.println("Good! Found occurences of letter " + guess);
                if (game.hasWon()) {
                    System.out.println("CONGRATULATIONS! YOU WON!");
                    keepPlaying = false;
                } else {
                    System.out.println(game.getCurrentName());
                }
            } else {
                System.out.println("Oh no! You made " + game.getMissedGuesses() + " wrong guess(es).");
                if (game.hasLost()) {
                    System.out.println("GAME OVER");
                    keepPlaying = false;
                } else {
                    System.out.println(game.getCurrentName());
                }
            }


        }
    }
}
