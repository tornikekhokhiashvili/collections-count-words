package com.epam.rd.autotasks;
import java.util.*;

public class Words {
    public String countWords(List<String> text) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String line : text) {
            String[] words = line.split("[ .,‘’(“—/:?!”;*)'\\\"-]|\\\\s+]");
            for (String word : words) {
                String cleanedWord = word.toLowerCase();
                if (cleanedWord.length() >= 4) {
                    wordCount.put(cleanedWord, wordCount.getOrDefault(cleanedWord, 0) + 1);
                }
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = wordCount.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) {
                iterator.remove();
            }
        }
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
        sortedEntries.sort(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));
        StringBuilder statistics = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            statistics.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        if (statistics.length() > 0) {
            statistics.setLength(statistics.length() - 1);
        }
        return statistics.toString().trim();
    }
}

