package com.sap.ariba.test;

class Person
{

    public int number;
    protected int j;

    public void talk ()
    {
        System.out.println("I am person");
    }
}

class student extends Person
{
    int j;
    public int talk (int i,
                     Person p)
    {

        super.number =10;
        super.j = 20;
        System.out.println(number + " j "+j);
        return 1;
    }
}

public class Test
{
    static String value = "Manoj";
    static int value1 = 51;

    static {
        value1 = 52;
        System.out.println(value);
        System.out.println(value1);
    }

    public static void main (String args[])
    {
        student p = new student();
        int x = 0;
        p.j =30;
        p.number =40;

        System.out.println(x + p.number);

        System.out.println("x =" + p.talk(0,p));

    }
}
