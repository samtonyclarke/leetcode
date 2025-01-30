import java.util.*;

public class MultiplyStrings {
    
    public static void main(String args[]) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
//        System.out.println(multiplyStrings.multiplyLargeNumbers("123456789", "987654321"));
//        System.out.println(multiplyStrings.multiplyLargeNumbers("123", "456"));
        System.out.println(multiplyStrings.multiplyLargeNumbers("9", "9"));
    }
    
    public String multiplyLargeNumbers(String num1, String num2) {

        System.out.println(num1 +" x "+num2);

        StringBuilder toReturn = new StringBuilder();
        if(num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int topLength = num1.length();
        int bottomLength = num2.length();
        String topNumber = num1;
        String bottomNumber = num2;
        if (topLength<bottomLength) {
            topNumber = num1;
            bottomNumber = num2;
            topLength = num2.length();
            bottomLength = num1.length();
        }

        int i = bottomLength-1;
        int carryOver = 0;
        ArrayList<String> toAdd = new ArrayList<>();
        int zeros=0;
        while(i>=0) {
            StringBuilder sb = new StringBuilder();
            for(int k=0;k<zeros;k++) {
                sb.insert(0, "0");
            }
            for(int j=topLength-1;j>=0;j--) {
                int bottomValue = bottomNumber.charAt(i) - '0';
                int topValue = topNumber.charAt(j) - '0';
                int compound = (bottomValue * topValue) + carryOver;
                int rightSide = compound % 10;
                if (compound>=10) {
                    carryOver = compound / 10;
                } else {
                    carryOver = 0;
                }
                sb.insert(0, rightSide);
            }
            if (carryOver>0) {
                sb.insert(0, carryOver);
                carryOver = 0;
            }
            zeros++;
            toAdd.add(sb.toString());
            i--;
        }
        String sum = "0";
        for(int j=0;j<toAdd.size();j++) {
            sum = addLargeNumbers(sum, toAdd.get(j));
        }
        
        return sum;  // placeholder
    }

    public String addLargeNumbers(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        ArrayList<Character> result = new ArrayList<>();

        while(i >= 0 || j >= 0 || carry != 0) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int current = n1 + n2 + carry;
            carry = current / 10;
            current = current % 10;
            result.add((char) ('0' + current));
            i--;
            j--;
        }

        Collections.reverse(result);
        StringBuilder resultString = new StringBuilder(result.size());
        for (Character c : result) {
            resultString.append(c);
        }
        return resultString.toString();
    }
}
