package comp1721.cwk1;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Game {

  private int gameNumber;
  private String target;
  private List<String> Guess = new ArrayList<>();


  // TODO: Implement constructor with String parameter
  public Game(String word) throws IOException {

    WordList attemptslist = new WordList(word);
    long numberdiff = ChronoUnit.DAYS.between(LocalDate.of(2021, 6, 19), LocalDate.now());
    gameNumber = (int) numberdiff;
    target = attemptslist.getWord(gameNumber);
  }


  // TODO: Implement constructor with int and String parameters
  public Game(int number, String word) throws IOException {
    WordList attemptslist = new WordList(word);
    target = attemptslist.getWord(gameNumber);
    gameNumber = number;
  }

  // TODO: Implement play() method
  public void play() {
    System.out.printf("Wordle %d %n%n", gameNumber);

    // for loop to make sure user only guesses 6 times
    for (int i = 1; i < 7; i++) {
      Guess guess = new Guess(i);
      System.out.printf("Enter guess (%d/6): ", guess.getGuessNumber());
      guess.readFromPlayer();
      Guess validateGuess = new Guess(i, guess.getChosenWord());
      System.out.println(guess.compareWith(target));
      Guess.add(guess.compareWith(target));

      if (guess.matches(target)) { // if guessed right in his first guess
        if (i == 1) {
          System.out.print("Superb - Got it in one!\n");
          break;
        } else if ((i > 1) && (i < 6)) { // if guessed right in his second to fifth guess
          System.out.print("Well done!\n");
          break;
        } else if (i == 6) { // If guessed right in his last guess
          System.out.print("That was a close call!\n");
          break;
        }
      }
      if (i == 6 && (!guess.matches(target))) { // Failed to guess word
        System.out.print("Nope - Better luck next time!\n");
        break;
      }
    }
  }

  // TODO: Implement save() method, with a String parameter
  public void save(String word) throws IOException {

  }
}
