package comp1721.cwk1;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.util.ArrayList;


public class WordList {

    private List<String>words= new ArrayList<>();

    public WordList(String filename) throws IOException {

        // open file and get word
        Scanner input = new Scanner(Paths.get(filename));
            while (input.hasNextLine()) {
                words.add((input.nextLine()));
            }
            input.close(); // close file once it gets word
    }

  // get word size
    public int size(){

        return words.size();
    }

  // check if word
    public String getWord(int n){
        int wordssize = words.size();
        if (n < 0 || wordssize <= n){
            throw new GameException("Invalid number");
        }
            return words.get(n);
        }
}
