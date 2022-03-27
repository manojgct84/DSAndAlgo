package com.sap.ariba.algoanddata.leecode.March;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A valid encoding of an array of words is any reference string s and array of indices indices such that:
 * <p>
 * words.length == indices.length
 * The reference string s ends with the '#' character.
 * For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
 * Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
 * words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
 * words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
 * words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
 * Example 2:
 * <p>
 * Input: words = ["t"]
 * Output: 2
 * Explanation: A valid encoding would be s = "t#" and indices = [0].
 */
public class ShortEncodingWords {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) {
            return 1;
        }
        // Use set to de-duplicate the string
        HashSet<String> strings = new HashSet<>();
        // Add data, automatic deduplication
        Collections.addAll(strings, words);

        Iterator<String> strs = strings.iterator();
        int size = 0;
        // Put all into the original words. In fact, a new String array with a size of strings.size() is
        // A better choice, for the sake of time, no error is reported during operation. Fortunately, no corresponding subscript array is required
        while (strs.hasNext()) {
            words[size++] = strs.next();
        }
        int result = 0, add;
        for (int i = 0; i < size; i++) {
            // Indicates the length that this string can add to the final string
            add = words[i].length() + 1;
            for (int j = 0; j < size; j++) {
                // If this string is a suffix of another string, then this string can be represented by it
                // No need to add another paragraph after the main string
                if (i != j && words[j].endsWith(words[i])) {
                    add = 0;
                    break;
                }
            }

            result += add;
        }

        return result;
    }

    public int minimumLengthEncodingSimple(String[] words) {

        Set<String> s = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                s.remove(word.substring(i));
            }
        }

        int sum = 0;

        for (String word : s) {
            sum += word.length() + 1;
        }

        return sum;
    }
}
