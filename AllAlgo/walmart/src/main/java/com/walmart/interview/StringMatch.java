package com.walmart.interview;

public class StringMatch {


    //str1 - walmart
    //str2 - wal4 or w2mart or wal5 -false
    //4walmart
    //

    public boolean stringMatch(String str1, String str2) {

        int i = 0;
        int j = 0;
        //walmart  TC O(N)   SC O(2N)
        //wa22art
        while (i < str1.length() && j < str2.length()) {

            if (isDigit(str2.charAt(j))) {
                int index = checkDigit(str2, j);

            } else if (str1.charAt(i) != str2.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return false;
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private int checkDigit(String match, int j) {
        StringBuilder buf = new StringBuilder();
        while (j < match.length()) {
            if (Character.isDigit(match.charAt(j))) {
                buf.append(match.charAt(j));
            }
        }
        return Integer.parseInt(buf.toString());
    }
}


