package B6_DataStructuresAndAlgorithmBasic.BaiTap.TreeMapWords;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapWords {
    public static void main(String args[]) {
        String str = "dog cat mice dog cat monkey monkey";
        String item[] = str.toLowerCase().split(" ");
        Map<String, Integer> wordCounter = new TreeMap<>();
        wordCounter.put("dog", 1);
        for (String t : item) {
            if (wordCounter.containsKey(t)) {
                wordCounter.put(t, wordCounter.get(t) + 1);

            } else {
                wordCounter.put(t, 1);
            }
        }
        for(String key:wordCounter.keySet())
        {
            System.out.println(key+""+wordCounter.get(key));
        }
    }
}
