package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dic = new HashMap<>();
        dic.put("beautiful", new String[]{"wonderful", "pretty", "gorgeous", "lovely"});
        dic.put("bad", new String[]{"eagle", "terrible", "horrible", "awful"});
        dic.put("smart", new String[]{"clever", "intelligent", "brilliant", "wise"});
        dic.put("stupid", new String[]{"bonehead", "mindless", "oafish", "dumb"});

        HashMap<String, String[]> bigDictionary = new HashMap();
        Set<String> keys = dic.keySet(); // getting all keys
        Iterator iterator = keys.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String[] values = dic.get(key);
            bigDictionary.put(key, values);

            for (int i = 0; i < values.length; i++) {
                String newKey = values[i];
                List<String> val = new ArrayList<>(values.length);
                val.addAll(Arrays.asList(values));
                val.remove(newKey);
                val.add(key);

                String[] newVal = new String[val.size()];

                newVal = val.toArray(newVal);

                bigDictionary.put(newKey, newVal); } }
        System.out.println("Type a word");

        Scanner scanner = new Scanner(System.in);
        String sentences = scanner.nextLine();
        String[] words = sentences.split(" ");

        Random r = new Random();

        for (int i = 0; i < words.length; i++) {
            String[] synonyms = bigDictionary.get(words[i]);

            if (synonyms != null) {
                int randomNumber = r.nextInt(synonyms.length);

                System.out.printf(synonyms[randomNumber] + " ");

            } else {
                System.out.println("There is no such a word!!! Try another one");
            }
        }
    }
}