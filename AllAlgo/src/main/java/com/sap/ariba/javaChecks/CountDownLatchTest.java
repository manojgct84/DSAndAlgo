package com.sap.ariba.javaChecks;

import java.util.concurrent.CountDownLatch;

class Waiter implements Runnable
{
    private CountDownLatch countDownLatch;

    Waiter (CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run ()
    {
        try {
            System.out.println("In Waiter");
            countDownLatch.await();
            System.out.println("In Waiter - Completed");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Decrementer implements Runnable
{
    private CountDownLatch countDownLatch;

    Decrementer (CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run ()
    {
        try {
            System.out.println("In Decrementer 1");
            Thread.sleep(1000);
            countDownLatch.countDown();
            System.out.println("In Decrementer 2");
            Thread.sleep(1000);
            countDownLatch.countDown();
            System.out.println("In Decrementer 3");
            Thread.sleep(1000);
            countDownLatch.countDown();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchTest
{
    public static void main (String args[])
    {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Waiter waiter = new Waiter(countDownLatch);
        Decrementer decrementer = new Decrementer(countDownLatch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

    }
}
