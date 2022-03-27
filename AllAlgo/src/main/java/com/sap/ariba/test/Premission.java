package com.sap.ariba.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Premission
{

    public static int increment = 1;
    private static String[] permission = { "MFAEnableOrDisable", "MFAReset" };

    public static List<String> requestPermissions (final String[] listOfPermissions,
                                                   final Employee employee)
    {

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(permission));
        ArrayList<String> permissionResult = new ArrayList<>();
        for (String permissionStr : listOfPermissions) {
            if (arrayList.contains(permissionStr)) {
                permissionResult.add(permissionStr);
            }
        }
         setIncrement();
        permissionResult.add(employee.toString());
        return permissionResult;
    }

    public static void setIncrement(){
        increment++;
    }
    public static int getCount(){
        return increment;
    }
}
