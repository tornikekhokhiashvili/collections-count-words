# Collections. Count words

## Description
Count words in a huge text and return statistics.

## Details
1. Implement `countWords` method in [Words](src/main/java/com/epam/rd/autotasks/Words.java) class.
2. An input parameter is a list of strings representing lines of text.
3. Count the words, that is build a display for each lower-cased word against its frequency in the text. 
 If the word *"kitten"* occurred in a text 23 times then its entry would be *"kitten - 23\n"*.
4. Return a String contains all the entries.
5. Skip all the words with length less than **4** and frequency less than **10** (to small or too rare words)
6. The entries in the resulting String should be also sorted based on their number and then in alphabetical order if needed.

Be sure to make your code handling texts that are not in English.
 
*You may not use streams, lambdas or method references in your code*
 
