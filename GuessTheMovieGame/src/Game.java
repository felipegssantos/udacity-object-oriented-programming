import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private String movieName;
    private String currentName;
    private Set<Character> wrongGuesses = new HashSet<Character>();

    Game() {
        movieName = chooseMovie();
        currentName = obfuscateName(movieName);
        System.out.println("DEBUG: the movie is " + movieName);
    }

    public boolean hasWon() {
        return currentName.equals(movieName);
    }

    public boolean hasLost() {
        return wrongGuesses.size() == 10;
    }

    public String getCurrentName() {
        return currentName;
    }

    public int getMissedGuesses() {
        return wrongGuesses.size();
    }

    private String obfuscateName(String movieName) {
        return movieName.replaceAll("[a-z]", "_");
    }

    public boolean analyzeGuess(char guess) {
        int index = movieName.indexOf(guess);

        if (index >= 0) {
            updateCurrentName(guess, index);
            return true;
        } else {
            wrongGuesses.add(guess);
            return false;
        }
    }

    private void updateCurrentName(char guess, int index) {
        char[] name = currentName.toCharArray();
        name[index] = guess;
        while (index >= 0) {
            name[index] = guess;
            index = movieName.indexOf(guess, index + 1);
        }
        currentName = String.valueOf(name);
    }

    private String chooseMovie() {
        int numberOfMovies = countLines();
        int movieIndex = (int) (Math.random() * numberOfMovies);
        return getMovieFromIndex(movieIndex);
    }

    private Scanner loadMoviesFromFile() {
        try {
            File moviesFile = new File("data/movies.txt");
            Scanner moviesList = new Scanner(moviesFile);
            return moviesList;
        } catch (FileNotFoundException e) {
            System.out.println("Movies file not found. Ask the developer to fix it.");
            return null;
        }
    }

    private int countLines() {
        int numberOfLines = 0;
        Scanner text = loadMoviesFromFile();

        while (text.hasNextLine()) {
            numberOfLines++;
            text.nextLine();
        }

        return numberOfLines;
    }

    private String getMovieFromIndex(int index) {
        int count = 0;
        String name = null;
        Scanner moviesList = loadMoviesFromFile();

        while (count < index) {
            name = moviesList.nextLine();
            count++;
        }

        return name;
    }
}
