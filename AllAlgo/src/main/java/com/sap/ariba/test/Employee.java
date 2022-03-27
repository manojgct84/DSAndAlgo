package com.sap.ariba.test;

public class Employee
{
    private int id;
    private String name;
    private String dep;

    public Employee (int id,
                     String name,
                     String dep)
    {
        this.id = id;
        this.name = name;
        this.dep = dep;
    }

    public int getId ()
    {
        return id;
    }

    public String getName ()
    {
        return name;
    }

    public String getDep ()
    {
        return dep;
    }

    @Override
    public String toString ()
    {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", dep='" + dep + '\'' + '}';
    }
}