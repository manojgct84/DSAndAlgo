package com.sap.ariba.javaChecks;

import org.apache.commons.lang3.StringUtils;
import java.security.PublicKey;

public class LeftPadding
{


    public static void main(String args[]){

        final StringBuilder result = new StringBuilder(Integer.toString(786547));
        stringPadding(10,result,result.length());
    }

    private static void stringPadding (final int requiredLen, final StringBuilder stringBuilder,
                                final int currentLen)
    {
        int length = currentLen;
        while (length < requiredLen) {
            stringBuilder.insert(0, "0");
            length++;
        }
        System.out.println("Apache Utils :" +StringUtils.leftPad(stringBuilder.toString(),
                                                              requiredLen, "0"));
        System.out.println(stringBuilder.toString());
    }
}
