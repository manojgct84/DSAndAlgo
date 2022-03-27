package com.sap.ariba.algoanddata;

import java.util.ArrayList;
import java.util.List;

public class GS {

   /*
    There is list of ingredients which is string - A,B,A,B,C,A,B,A,B,C,D - Now we need to reduce the ingredients list such that is compressed from to share it.
       Input String - A,B,A,B,C,A,B,A,B,C,D : Output : A,B,*,C,*D
    Input String- A,B,C,A,B,C,E : Output : A,B,C,*,E.
    */

    //A,B,A,B,C,A,B,A,B,C,D - result A,B,,C,,D
    //A,B,C,A,B,C,E = A,B,C,*,E

    public static void main(String[] args) {
        System.out.println(getLessIntegrdents("ABABCABABCD"));
    }

    private static int getLessIntegrdents(String integrdents) {
        char[] integrdent = integrdents.toCharArray();
        List<Character> temp = new ArrayList<>();
        List<Character> result = new ArrayList<>();

        result.add(integrdent[0]);
        temp.add(integrdent[0]);
        int i = 0;

        while (i < integrdent.length) {
            int k = i + 1;
            int j = 0;
            while (k < integrdent.length) {
                if (temp.get(j) != integrdent[k]) {
                    result.add(integrdent[k]);
                    temp.add(integrdent[k]);
                    j = 0;
                    k++;
                } else {
                    if (result.get(result.size() - 1) == '*') {
                        j++;
                        k++;
                    } else {
                        result.add('*');
                    }
                    temp.add(integrdent[k]);
                }
            }
            i = k;
        }
        return result.size();
    }
}
