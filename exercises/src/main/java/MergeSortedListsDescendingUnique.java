import java.util.ArrayList;
import java.util.List;

public class MergeSortedListsDescendingUnique {
    
    public static void main(String args[]) {
        MergeSortedListsDescendingUnique mergeSortedListsDescendingUnique = new MergeSortedListsDescendingUnique();
        mergeSortedListsDescendingUnique.mergeSortedListsDescendingUnique(List.of(100, 200, 300, 400, 500), List.of(100, 200, 300, 400, 500));
        
    }

    public List<Integer> mergeSortedListsDescendingUnique(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> toReturn = new ArrayList<>();

        // TODO this is not efficient as it adds elements at the front of a list which is O(n) for each operation
        // TODO better to read the existing list from the back and then append to the new list
        
        int i1=0;
        int i2=0;
        while(i1<list1.size() && i2<list2.size()) {
            if(list1.get(i1) < list2.get(i2)) {
                prepend(toReturn, list1.get(i1));
                i1++;
            } else {
                prepend(toReturn, list2.get(i2));
                i2++;
            }
        }
        while(i1<list1.size()) {
            prepend(toReturn, list1.get(i1));
            i1++;
        }
        while(i2<list2.size()) {
            prepend(toReturn, list2.get(i2));
            i2++;
        }

        return toReturn;
    }

    void prepend(List<Integer> nums, Integer next) {
        if(nums.isEmpty()) {
            nums.add(next);
            return;
        }
        Integer prior = nums.get(0);
        if (prior.equals(next)) {
            return;
        }
        nums.add(0, next);
    }
    
}
