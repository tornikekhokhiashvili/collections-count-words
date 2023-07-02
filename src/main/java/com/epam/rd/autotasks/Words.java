package com.epam.rd.autotasks;
import java.util.*;

public class Words {
    public static String countWords(List<String> text) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Iterate over each line of text
        for (String line : text) {
            // Split the line into words using whitespace as delimiter
            String[] words = line.split("\\s+");

            // Count the occurrence of each word
            for (String word : words) {
                // Remove non-alphabetic characters from the word
                String cleanedWord = word.replaceAll("[^\\p{L}]", "");

                // Exclude words with less than 4 letters
                if (cleanedWord.length() >= 4) {
                    // Convert the word to lowercase
                    cleanedWord = cleanedWord.toLowerCase();

                    // Update the word count
                    wordCount.put(cleanedWord, wordCount.getOrDefault(cleanedWord, 0) + 1);
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

        // Sort the word count entries by amount and then alphabetically
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                int result = Integer.compare(entry2.getValue(), entry1.getValue()); // Sort by amount in descending order
                if (result == 0) {
                    result = entry1.getKey().compareTo(entry2.getKey()); // Sort alphabetically if amounts are equal
                }
                return result;
            }
        });

        // Build the statistics string
        StringBuilder statistics = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            statistics.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        // Remove the trailing newline character if the statistics string is not empty
        if (statistics.length() > 0) {
            statistics.setLength(statistics.length() - 1);
        }

        return statistics.toString();
    }
}

