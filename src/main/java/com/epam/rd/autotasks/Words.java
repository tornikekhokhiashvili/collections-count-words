package com.epam.rd.autotasks;
import java.util.*;

public class Words {
    public String countWords(List<String> lines) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Iterate over each line of text
        for (String line : lines) {
            // Split the line into words using regex with the UNICODE_CHARACTER_CLASS flag
            String[] words = line.split("\\P{L}+", -1);

            for (String word : words) {
                // Ignore words with less than 4 letters
                if (word.length() >= 4) {
                    String lowercaseWord = word.toLowerCase();
                    int count = wordCount.getOrDefault(lowercaseWord, 0);
                    wordCount.put(lowercaseWord, count + 1);
                }
            }
        }

        // Filter out words with less than 10 occurrences
        Iterator<Map.Entry<String, Integer>> iterator = wordCount.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) {
                iterator.remove();
            }
        }

        // Sort the words by count and then alphabetically
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                int countComparison = Integer.compare(b.getValue(), a.getValue());
                if (countComparison == 0) {
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return countComparison;
                }
            }
        });

        // Generate the statistics string
        StringBuilder statistics = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedWords) {
            statistics.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        return statistics.toString();
    }
}
