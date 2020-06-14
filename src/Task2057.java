import java.util.*;
import java.io.*;

public class Task2057 {
    private static final String fileName = "input.txt";

    public Task2057() throws FileNotFoundException {
        TreeMap<Integer, Integer> currentSet = new TreeMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        try {
            int n = Integer.parseInt(reader.readLine());
            int item;
            while (n > 0) {
                String operations = reader.readLine();
                if (operations.charAt(0) == '1') {//add item
                    item = Integer.parseInt(operations.substring(2));
                    currentSet.put(item, currentSet.getOrDefault(item, 0) + 1);
                } else {//delete min item
                    Map.Entry<Integer, Integer> current = currentSet.firstEntry();
                    System.out.println(current.getKey());
                    int currentCount = current.getValue();
                    if (currentCount > 1) {
                        currentSet.put(current.getKey(), currentCount - 1);
                    } else {
                        currentSet.remove(current.getKey());
                    }
                }
                n--;
            }
        } catch (IOException e) {
        }
    }
}
