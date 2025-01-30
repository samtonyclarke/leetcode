import java.util.Arrays;

public class HouseGame {

//    In a unique town, there's a popular game that involves the town's houses and their numbers. 
//    What's special about this town is that each house is sequentially numbered from 1 to n. 
//    The game is played based on an interesting rule regarding these house numbers.
//
//    At each step of the game, every house number must "donate" one of its digits to the house 
//    on its right (or in the case of the last house, to the first house). The particular digit to be 
//    transferred in each step is dependent on the current game step: during the i-th step, the i-th 
//    digit from the right of each house number (1-indexed) is transferred. If a house number doesn't 
//    have the specified number of digits for a step, it doesn't donate any digit in that step.
//
//    During the transfer, the chosen digit is removed from its position in the donor house number
//    and then added to the front (leftmost side) of the receiving house number. All numbers change 
//    simultaneously.
//
//    The function, houseGame(int[] houses), should simulate each step of the game, starting from 
//    transferring the rightmost (1st digit) and proceeding one digit position towards the left 
//    in each successive step, until there is no change in the house numbers from one step to the 
//    next. It should return the sequence of house numbers at the end.
//
//    It is guaranteed that there are at least two houses and there is no digit 0 in the numbers.
//
//    For instance, if houses = [155, 52, 154, 4], the function should perform as follows:
//
//    Step 1 -> transfer the 1st digit from the right, the array becomes [415, 55, 215, 4].
//
//    Step 2 -> transfer the 2nd digit from the right, the array becomes [45, 15, 525, 14].
//
//    Step 3 -> transfer the 3rd digit from the right, the array becomes [45, 15, 25, 514].
//
//    Step 4 leaves the array same so the process stops and the output should be [45, 15, 25, 514].
    
    public static void main(String args[]) {
        HouseGame houseGame = new HouseGame();
//        houseGame.houseGame(new int[]{123, 234, 345, 456});
        houseGame.houseGame(new int[]{155, 52, 154, 4});
    }

    public int[] houseGame(int[] houses) {

        System.out.println("Houses: "+ Arrays.toString(houses));

        String[] oldHouses = Arrays.stream(houses)
                .mapToObj(String::valueOf) // Convert each int to String
                .toArray(String[]::new);

        String []newHouses = Arrays.copyOf(oldHouses, oldHouses.length);

        int i=0;
        while(true) {
            for(int j=0;j<oldHouses.length;j++) {
                Character ith = getIthDigit(oldHouses[j], i);
                if (ith != null) {
                    newHouses[j] = removeIthDigit(newHouses[j], i);
                    System.out.println("Removing digit: "+newHouses[j]);
                    System.out.println("n1: "+Arrays.toString(newHouses));
                    int nextIndex = (j+1) % oldHouses.length;
                    newHouses[nextIndex] = addDigit(newHouses[nextIndex], ith);
                    System.out.println("n2: "+Arrays.toString(newHouses));
                }
                System.out.println("Ith digit is: "+ith);
            }

            if(!canContinue(oldHouses, newHouses)) {
                System.out.println("Old houses: "+Arrays.toString(oldHouses));
                System.out.println("New houses: "+Arrays.toString(newHouses));
                System.out.println("Cannot continue when i is: "+i);
                break;
            }
            oldHouses = Arrays.copyOf(newHouses, newHouses.length);
            i++;
        }

        return Arrays.stream(newHouses).mapToInt(Integer::parseInt).toArray();

    }

    boolean canContinue(String[] oldHouses, String[] newHouses) {
        return !Arrays.equals(oldHouses, newHouses);
    }

    Character getIthDigit(String number, int i) {
        if (number.length() -1 < i) {
            return null;
        }
        else {
            return Character.valueOf(number.charAt(number.length() - i -1 ));
        }
    }

    String removeIthDigit(String number, int i) {
        StringBuilder sb = new StringBuilder(number);
        sb.deleteCharAt(number.length() - i -1);
        return sb.toString();
    }

    String addDigit(String number, Character digit) {
        return digit+number;
    }
    
}
