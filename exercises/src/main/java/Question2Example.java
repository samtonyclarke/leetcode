import java.util.ArrayList;
import java.util.List;

public class Question2Example {
    public static void main(String args[]) {
        Question2Example question2Example = new Question2Example();    
//        question2Example.numberOfSubString("010", "amazing");
        question2Example.numberOfSubString("100", "codesignal");
    }

    private List<String> vowels = new ArrayList<>();
    
    Question2Example() {
        vowels.addAll(List.of("a", "e", "i", "o", "u"));
    }
    
    
    
    int numberOfSubString(String pattern, String source) {
        
        int substringLength = pattern.length();
        int count = 0;
        for(int i=0;i<source.length()-substringLength;i++) {
            if (matches(pattern, source.substring(i, substringLength+i))) {
                count++;
            }
        }
        
        return count;
    }
    
    boolean matches(String pattern, String source) {
        for (int i=0;i<pattern.length();i++) {
            if(vowels.contains(String.valueOf(source.charAt(i)))) {
                if (pattern.charAt(i) != '0') {
                    return false;
                }
            } else {
                if (pattern.charAt(i) != '1') {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
}
