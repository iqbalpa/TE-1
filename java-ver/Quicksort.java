// import java.util.*;

// public class Quicksort {
//     // use stack to avoid stack overflow
//     public static void quickSort(int[] arr) {
//         Stack<List<Integer>> stack = new Stack<>();
//         int start = 0;
//         int end = arr.length - 1;
//         stack.push(Arrays.asList(start, end));
//         while (!stack.isEmpty()) {
//             List<Integer> list = stack.pop();
//             start = list.get(0);
//             end = list.get(1);
//             if (start >= end) {
//                 continue;
//             }
//             int[] p = partition(arr, start, end);
//             stack.push(Arrays.asList(start, p[0] - 1));
//             stack.push(Arrays.asList(p[0] + 1, p[1] - 1));
//             stack.push(Arrays.asList(p[1] + 1, end));
//         }
//     }
//     public static int[] partition(int[] arr, int start, int end) {
//         int p = arr[start];
//         int q = arr[end];
//         int B = 1024;
//         int[] block = new int[B];
//         int i = start + 1, j = start + 1, k = start + 1;
//         int num_p = 0, num_q = 0;
//         while (k < end) {
//             int t = Math.min(B, end - k);
//             int c = 0;
//             while (c < t) {
//                 block[num_q] = c;
//                 num_q += (q >= arr[k + c] ? 1 : 0);
//                 c++;
//             }
//             c = 0;
//             while (c < num_q) {
//                 int temp = arr[j + c];
//                 arr[j + c] = arr[k + block[c]];
//                 arr[k + block[c]] = temp;
//                 c++;
//             }
//             k += t;
//             c = 0;
//             while (c < num_q) {
//                 block[num_p] = c;
//                 num_p += (p > arr[j + c] ? 1 : 0);
//                 c++;
//             }
//             c = 0;
//             while (c < num_p) {
//                 int temp = arr[i];
//                 arr[i] = arr[j + block[c]];
//                 arr[j + block[c]] = temp;
//                 i++;
//                 c++;
//             }
//             j += num_q;
//             num_p = 0;
//             num_q = 0;
//         }
//         int temp = arr[i - 1];
//         arr[i - 1] = arr[start];
//         arr[start] = temp;
//         temp = arr[j];
//         arr[j] = arr[end];
//         arr[end] = temp;
//         return new int[]{i - 1, j};
//     }
// }


import java.util.*;

public class Quicksort {
    // use stack to avoid stack overflow
    public static void quickSort(List<Integer> arr) {
        Stack<List<Integer>> stack = new Stack<>();
        int start = 0;
        int end = arr.size() - 1;
        stack.push(Arrays.asList(start, end));
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            start = list.get(0);
            end = list.get(1);
            if (start >= end) {
                continue;
            }
            List<Integer> p = partition(arr, start, end);
            stack.push(Arrays.asList(start, p.get(0) - 1));
            stack.push(Arrays.asList(p.get(0) + 1, p.get(1) - 1));
            stack.push(Arrays.asList(p.get(1) + 1, end));
        }
    }

    public static List<Integer> partition(List<Integer> arr, int start, int end) {
        int p = arr.get(start);
        int q = arr.get(end);
        int B = 1024;
        List<Integer> block = new ArrayList<>(B);
        for (int i = 0; i < B; i++) {
            block.add(0);
        }
        int i = start + 1, j = start + 1, k = start + 1;
        int num_p = 0, num_q = 0;
        while (k < end) {
            int t = Math.min(B, end - k);
            int c = 0;
            while (c < t) {
                block.set(num_q, c);
                num_q += (q >= arr.get(k + c) ? 1 : 0);
                c++;
            }
            c = 0;
            while (c < num_q) {
                int temp = arr.get(j + c);
                arr.set(j + c, arr.get(k + block.get(c)));
                arr.set(k + block.get(c), temp);
                c++;
            }
            k += t;
            c = 0;
            while (c < num_q) {
                block.set(num_p, c);
                num_p += (p > arr.get(j + c) ? 1 : 0);
                c++;
            }
            c = 0;
            while (c < num_p) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j + block.get(c)));
                arr.set(j + block.get(c), temp);
                i++;
                c++;
            }
            j += num_q;
            num_p = 0;
            num_q = 0;
        }
        int temp = arr.get(i - 1);
        arr.set(i - 1, arr.get(start));
        arr.set(start, temp);
        temp = arr.get(j);
        arr.set(j, arr.get(end));
        arr.set(end, temp);
        return Arrays.asList(i - 1, j);
    }
}
