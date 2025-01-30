import java.util.ArrayList;
import java.util.List;

public class ShiftList {

    public static void main(String args[]) {
        ShiftList shiftList = new ShiftList();
        shiftList.shiftListElements(List.of(8, 20, -3, 23, 32, -4, 7), 3);
    }
    
    public List<Integer> shiftListElements(List<Integer> ls, int shift) {
        System.out.println("processing: "+ls+ " with shift: "+shift);
        ArrayList<Integer> toReturn = new ArrayList<>();
        int size = ls.size();

        shift = shift % size;

        for(int i=0;i<size;i++) {

            int takeFrom = (i + size - shift) % size;

            toReturn.add(ls.get(takeFrom));
        }
        System.out.println("result: "+toReturn);
        return toReturn;
    }
}
