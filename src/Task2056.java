import java.util.*;
import java.io.*;

public class Task2056 {
    private static final String fileName = "input.txt";

    public Task2056() throws FileNotFoundException {
        TreeMap<String, Integer> words = new TreeMap();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        try {
            String str = reader.readLine();
            while (str != null) {
                StringTokenizer st = new StringTokenizer(str, " ");
                while (st.hasMoreTokens()) {
                    String word = st.nextToken().toLowerCase();
                    words.put(word, words.getOrDefault(word, 0) + 1);
                }
                str = reader.readLine();
            }
            Integer max = Collections.max(words.entrySet(), Map.Entry.comparingByValue()).getValue();
            for (Object key : words.keySet()) {
                if (words.get(key).equals(max)) {
                    System.out.println(key);
                }
            }
        } catch (IOException e) {
        }
    }
}