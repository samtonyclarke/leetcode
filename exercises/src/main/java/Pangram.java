import java.util.HashSet;

public class Pangram {
    public static void main(String args[]) {
        Pangram pangram = new Pangram();
        pangram.checkIfPangram("thisthat");
    }

    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }
    
}
