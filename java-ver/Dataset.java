import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Dataset {
    public List<Integer> generateRandom(int n){
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++){
            list.add(rand.nextInt(2048));
        }
        return list;
    }
    public List<Integer> generateSorted(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        return list;
    }
    public List<Integer> generateReverseSorted(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = n; i > 0; i--){
            list.add(i);
        }
        return list;
    }
    // save data into file
    public void saveData(){
        Integer n = 512; // 2^9
        List<Integer> random9 = generateRandom(n);
        List<Integer> sorted9 = generateSorted(n);
        List<Integer> reverseSorted9 = generateReverseSorted(n);
        n = 8192;  // 2^13
        List<Integer> random13 = generateRandom(n);
        List<Integer> sorted13 = generateSorted(n);
        List<Integer> reverseSorted13 = generateReverseSorted(n);
        n = 65536; // 2^16
        List<Integer> random16 = generateRandom(n);
        List<Integer> sorted16 = generateSorted(n);
        List<Integer> reverseSorted16 = generateReverseSorted(n);

        // serialize the ArrayList and save it to a file
        serializeArrayList((ArrayList<Integer>) random9, "random9.ser");
        serializeArrayList((ArrayList<Integer>) sorted9, "sorted9.ser");
        serializeArrayList((ArrayList<Integer>) reverseSorted9, "reversed9.ser");
        serializeArrayList((ArrayList<Integer>) random13, "random13.ser");
        serializeArrayList((ArrayList<Integer>) sorted13, "sorted13.ser");
        serializeArrayList((ArrayList<Integer>) reverseSorted13, "reversed13.ser");
        serializeArrayList((ArrayList<Integer>) random16, "random16.ser");
        serializeArrayList((ArrayList<Integer>) sorted16, "sorted16.ser");
        serializeArrayList((ArrayList<Integer>) reverseSorted16, "reversed16.ser");
    }
    // load data from file
    public Map<String, List<Integer>> loadData(){
        Map<String, List<Integer>> map = new TreeMap<>();
        map.put("random9", deserializeArrayList("./dataset/random9.ser"));
        map.put("sorted9", deserializeArrayList("./dataset/sorted9.ser"));
        map.put("reversed9", deserializeArrayList("./dataset/reversed9.ser"));
        map.put("random13", deserializeArrayList("./dataset/random13.ser"));
        map.put("sorted13", deserializeArrayList("./dataset/sorted13.ser"));
        map.put("reversed13", deserializeArrayList("./dataset/reversed13.ser"));
        map.put("random16", deserializeArrayList("./dataset/random16.ser"));
        map.put("sorted16", deserializeArrayList("./dataset/sorted16.ser"));
        map.put("reversed16", deserializeArrayList("./dataset/reversed16.ser"));
        return map;
    }

    // Method to serialize the ArrayList and save it to a file
    private void serializeArrayList(ArrayList<Integer> list, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(list);
            System.out.println("ArrayList saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to deserialize the ArrayList from the file
    private ArrayList<Integer> deserializeArrayList(String filePath) {
        ArrayList<Integer> deserializedList = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            deserializedList = (ArrayList<Integer>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedList;
    }
}