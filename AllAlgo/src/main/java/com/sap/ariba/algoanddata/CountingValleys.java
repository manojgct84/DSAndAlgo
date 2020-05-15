package com.sap.ariba.algoanddata;

public class CountingValleys
{

    public static void main (String args[])
    {
        System.out.println(countingValleys(8,
                        "UDDDUDUU"));
    }

    static int countingValleys (int n,
                                String s)
    {
        int valleyCossed = 0;
        int upDownCount = 0;
        char[] garyWalk = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (garyWalk[i] == 'U') {
                upDownCount++;

                if (upDownCount == 0) {
                    valleyCossed++;
                }
            }
            else {
                upDownCount--;
            }
        }

        return valleyCossed;
    }
}
