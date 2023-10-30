import java.util.*;

public class Mergesort {
    public static List<Integer> mergesort(List<Integer> myList) {
        if (myList.size() <= 1) {
            return myList;
        }
        int mid = myList.size() / 2;
        List<Integer> left = mergesort(new ArrayList<>(myList.subList(0, mid)));
        List<Integer> right = mergesort(new ArrayList<>(myList.subList(mid, myList.size())));
        return merge(left, right);
    }
    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }
}
