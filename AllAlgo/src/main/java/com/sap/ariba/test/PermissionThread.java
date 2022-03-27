package com.sap.ariba.test;

import java.util.ArrayList;

public class PermissionThread implements Runnable
{
    private String[] PERMISSIONS;
    private Employee employee;
    public PermissionThread (String[] PERMISSIONS,Employee employee)
    {
        this.PERMISSIONS = PERMISSIONS;
        this.employee = employee;
    }

    @Override
    public void run ()
    {
        Thread.currentThread().setName("Thread Name -" + PERMISSIONS[0]);
        System.out.println(Thread.currentThread().getName()+" start.");
        System.out.println(Premission.requestPermissions(PERMISSIONS,employee));
        System.out.println(Thread.currentThread().getName()+" End.");
    }
}
