package comp1721.cwk1;

import java.util.Scanner;
import java.lang.String;


public class Guess {


  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  private int guessNumber;
  private String chosenWord;


  // constructor
  public Guess(int number) {

    // if guess is not in the range 1-6 -> throw GameException
    if (number < 1 || number > 6) {
      throw new GameException("Invalid number");
    } else {
      guessNumber = number;
    }


  }

  public Guess(int number, String word) {

    // if guess number is not in the range 1-6 -> throw GameException
    if (number < 1 || number > 6) {
      throw new GameException("Invalid Number");

      //if the word length is different from 5 -> throw GameExceptions
    } else if (word.length() != 5) {
      throw new GameException("Invalid word size");
    }

    //
    int digit = 0;
    char checkwordchar;

    // for loop that looks for non-alphabetic characters
    for (int i = 0; i < 5; i++) {
      checkwordchar = word.charAt(i);
      if (Character.isDigit(checkwordchar)) {
        digit++;
      }
    }
    // if digit is found it means word is not made of only alphabet characters -> throw GameException
    if (digit != 0) {
      throw new GameException("Does not consist of 5 alphabetic characters");
    } else {
      guessNumber = number;
      chosenWord = word.toUpperCase(); // make sure chosenWord is in upper case
    }

  }

  //get guessNumber as an int
  public int getGuessNumber() {
    return guessNumber;

  }

  //get chosenWord as a string
  public String getChosenWord() {

    return chosenWord;
  }


  public void readFromPlayer() {
    chosenWord = INPUT.next(); // scanner to get users input
    chosenWord = chosenWord.toUpperCase();

  }

  // TODO: Implement compareWith(), giving it a String parameter and String return type
  //---------------------------------------------------------------------------------------------//
  public String compareWith(String target) {

    StringBuilder guessword = new StringBuilder();
    String Green = "\033[30;102m ";
    String Yellow = "\033[30;103m ";
    String Grey = "\033[30;107m ";
    String Reset = " \033[0m";
    String replaced;
    String replaceduser;
      char[] checkcw = chosenWord.toCharArray();
      char[] checktarget = target.toCharArray();
      // check if character is repeated
      boolean rightletter = false;
      // for checks user
      for (int i = 0; i < 5; i++) {
        // Second one is to loop through each letter of the target
        for (int j = 0; j < 5; j++) {
          // Check if the letter are same
          if (checkcw[i] == checktarget[j]) {
            // if letter is the same = true
            rightletter = true;
            // check if word in the same place
            if (i == j) {
              // Add word to stringbuild in green
              guessword.append(Green + checkcw[i] + Reset); // Green
              //replace character with '.'
              checktarget[j] = '.';
              continue;
            }
            // Add word to stringbuild in yellow
            guessword.append(Yellow + checkcw[i] + Reset); // Yellow
            // replace character with '.'
            checktarget[j] = '.';
            continue;
          }
        }
        // if not green or yellow
        if (!rightletter) {
          guessword.append(Grey + checkcw[i] + Reset); // Grey
        }
        rightletter = false;
      }
      return guessword.toString();
    }



  public boolean matches(String target) {

    //Check if word chosen by user is the same target word, if it return true if not return false
    if (chosenWord.equals(target.toUpperCase())) {
      return true;
    }
    else {
      return false;
    }
  }
}
