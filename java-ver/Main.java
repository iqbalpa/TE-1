import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dataset dataset = new Dataset();
        // dataset.saveData();
        Map<String, List<Integer>> map = dataset.loadData();
        List<Integer> random9 = map.get("random9");
        List<Integer> sorted9 = map.get("sorted9");
        List<Integer> reversed9 = map.get("reversed9");
        List<Integer> random13 = map.get("random13");
        List<Integer> sorted13 = map.get("sorted13");
        List<Integer> reversed13 = map.get("reversed13");
        List<Integer> random16 = map.get("random16");
        List<Integer> sorted16 = map.get("sorted16");
        List<Integer> reversed16 = map.get("reversed16");
        
        // TEST ALGORITHM
        System.out.println(">>>>>>>>>> 2^16 <<<<<<<<<<");
        System.out.println("===== random =====");
        System.out.println(">>> mergesort");
        runMergesort(random16);
        System.out.println(">>> quicksort");
        runQuicksort(random16);
        System.out.println("===== sorted =====");
        System.out.println(">>> mergesort");
        runMergesort(sorted16);
        System.out.println(">>> quicksort");
        runQuicksort(sorted16);
        System.out.println("===== reversed =====");
        System.out.println(">>> mergesort");
        runMergesort(reversed16);
        System.out.println(">>> quicksort");
        runQuicksort(reversed16);
    }

    // run mergesort
    public static void runMergesort(List<Integer> list){
        Runtime runtime = Runtime.getRuntime();
        List<Integer> msList = new ArrayList<>(list);
        
        long beforeUsedMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();
        List<Integer> sorted = Mergesort.mergesort(msList);
        long endTime = System.nanoTime();
        long afterUsedMemory = runtime.totalMemory() - runtime.freeMemory();
        
        long memoryUsed = afterUsedMemory - beforeUsedMemory;
        long durationInNano = endTime - startTime;
        double durationInSeconds = (double) durationInNano / 1_000_000_000.0;

        System.out.println("Time taken: " + durationInSeconds + " seconds");
        System.out.println("Memory used: " + memoryUsed + " bytes");
    }

    // run quicksort
    public static void runQuicksort(List<Integer> list){
        Runtime runtime = Runtime.getRuntime();
        List<Integer> qcList = new ArrayList<>(list);

        long beforeUsedMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();
        Quicksort.quickSort(qcList);
        long endTime = System.nanoTime();
        long afterUsedMemory = runtime.totalMemory() - runtime.freeMemory();

        long memoryUsed = afterUsedMemory - beforeUsedMemory;
        long durationInNano = endTime - startTime;
        double durationInSeconds = (double) durationInNano / 1_000_000_000.0;

        System.out.println("Time taken: " + durationInSeconds + " seconds");
        System.out.println("Memory used: " + memoryUsed + " bytes");
    }
}