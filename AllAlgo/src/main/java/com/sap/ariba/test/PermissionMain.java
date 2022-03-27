package com.sap.ariba.test;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PermissionMain
{
    private static final String[] PERMISSIONS1 = { "MFAEnableOrDisable" };
    private static final String[] PERMISSIONS2 = { "MFAReset" };

    public static void main (String args[])
    {

       /* Thread t1 = new Thread(new PermissionThread(PERMISSIONS1));
        t1.start();

        Thread t2 = new Thread(new PermissionThread(PERMISSIONS2));
        // t2.sleep(500);
        t2.start();
*/
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,
                                   "A",
                                   "1"));
        employees.add(new Employee(2,
                                   "B",
                                   "2"));
        employees.add(new Employee(3,
                                   "C",
                                   "2"));
        employees.add(new Employee(4,
                                   "D",
                                   "2"));
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        ArrayList<PermissionThread> thread = new ArrayList<>();
        thread.add(new PermissionThread(PERMISSIONS1,employees.get(0)));
        thread.add(new PermissionThread(PERMISSIONS2,employees.get(1)));
        thread.add(new PermissionThread(PERMISSIONS2,employees.get(2)));
        thread.add(new PermissionThread(PERMISSIONS1,employees.get(3)));

        for (int i = 0; i < thread.size(); i++) {
            executorService.submit(thread.get(i));
            System.out.println(String.format("Static Var %s" , Premission.getCount()));
        }

        executorService.shutdown();
    }
}
