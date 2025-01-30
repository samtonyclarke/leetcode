import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CommonLetters {
    
    public static void main(String args[]) {
        CommonLetters commonLetters = new CommonLetters();
        commonLetters.solution("aaaaaaaaa", new char[]{'a', 'b', 'c'});
    }

    public char[] solution(String s, char[] letters) {

        
        

        List<Character> letterList = new ArrayList<>();
        for (char c : letters) {
            letterList.add(c);
        }
        System.out.println("S: "+s+" letters: "+letterList);

        HashSet<Character> letterSet = new HashSet<>(letterList);

        List<Character> common = new ArrayList<>();

        for(int i=0;i<s.length();i++) {
            Character n = s.charAt(i);
            if (letterSet.contains(n)) {
                common.add(n);
            }
        }
        Collections.sort(common);

        char[] charArray = new char[common.size()];
        for (int i = 0; i < common.size(); i++) {
            charArray[i] = common.get(i);
        }

        return charArray;
    }
    
}
