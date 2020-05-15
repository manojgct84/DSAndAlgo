package com.sap.ariba.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ScheduleTask implements Callable<String>
{

    private long todayNumberDays = 0;
    private long equalDaysToSendEmails = 0;

    public static void main (String args[]) throws ExecutionException, InterruptedException
    {
       /* Thread thread = new Thread(new ScheduleTask());
        thread.start();
*/
        //Executor Service to run it as thread mode.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = new ScheduleTask();
        Future<String> future = executor.submit(callable);
        System.out.println(future.get());
        //Executor Service has to be shut down to exit the process
        executor.shutdown();
    }

    //@Override
    /* Skip the Sat and Sunday dates.
     */
    public String run ()
    {
        LocalDate currentDate = LocalDate.now();
        String fileName = "/Users/i520859/Last_Freq_";
        String fileDate = String.valueOf(currentDate);
        int frequency = 3;
        for (int i = 0; i < 31; i++) {
            DayOfWeek day = DayOfWeek.of(currentDate.get(ChronoField.DAY_OF_WEEK));
            switch (day) {
            case SATURDAY:
                System.out.println("Weekend - Saturday");
                break;
            case SUNDAY:
                System.out.println("Weekend - Sunday");
                break;
            default:
                System.out.println("Not a Weekend");
                if (periodFrequency(currentDate,
                                    frequency)) {
                    BufferedWriter writer = getFileNameDetails(fileName,
                                                               fileDate);
                    try {
                        writer.write(currentDate + " " + day);
                        writer.newLine();
                        System.out.println("currentDate " + currentDate);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        if (writer != null) {
                            try {
                                writer.close();
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                break;
            }
            currentDate = currentDate.plusDays(1);
        }
        return ("Process Completed");
    }

    private BufferedWriter getFileNameDetails (String fileName, String currentDate)
    {
        BufferedWriter writer = null;
        File file = new File(fileName + currentDate + ".txt");
        try {
            if (!file.exists()) {
                System.out.println("File exists");
                file.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(file, true));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }

    /* This is to calculate the frequency based on the current date and end date
     *  do module operation on the date period and frequency number and if it zero
     *  it is the date for sending email
     */
    private boolean periodFrequency (LocalDate currentDate, int frequency)
    {
        //To make the job run based on the perodic frequency
        LocalDate ldt = LocalDate.now().plusDays(30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy",
                                                                  Locale.ENGLISH);
        //System.out.println(ldt);
        //String date = formatter.format(ldt);
        //System.out.println("Formatted Date >> " + date);
        long diffInDays = ChronoUnit.DAYS.between(currentDate,
                                                  ldt);
        if (diffInDays % frequency == 0) {
            System.out.println("Job will run on this day " + diffInDays / frequency);
            return true;
        }
        return false;
        //End
    }

    @Override
    public String call ()
    {
        //To calculate the percentage of email to send
        return runPercentageJob();
        //The below method is used for period of frequency.
        //return run();
    }

    /*
      The percentage & mail to sent are stored in the HashMap
       The percentage are checked based on the current date and stop date.
       The percentage difference between first and second entry are got and we equal split the
       days to send the email for the particular percentage.
        ex : -The difference between 90 and 75 to know number of days present to equally send the
         90% -2 emails.
           90% - (2) email to send
           75% - (5) email to send
           50% - (10) email to send
     */
    private String runPercentageJob ()
    {

        LocalDate stop = LocalDate.now().plusDays(80);
        Map<Long, Integer> pergentage = new LinkedHashMap<>();
        pergentage.put((long)90,1);
        pergentage.put((long)75,3);
        pergentage.put((long)50,5);
        pergentage.put((long)30,10);
        LocalDate currentDate = LocalDate.now();
        int sentCount = 0;
        Map<Integer, Integer> processCompleted = new HashMap<>();
        int percentage = 0;
        int currentPercentage = 0;
        boolean pregentageMeet = false;
        //processCompleted.put(30,2);
        int count = 0;
        boolean countMeet = true;
        boolean firstTime = true;
        boolean emailSendOutMeet = false;
        int skipDaysToMakeEqualDays = 0;
        for (int i = 0; i < 80; i++) {
            DayOfWeek day = DayOfWeek.of(currentDate.get(ChronoField.DAY_OF_WEEK));
            switch (day) {
            case SATURDAY:
                System.out.println("Weekend - Saturday");
                break;
            case SUNDAY:
                System.out.println("Weekend - Sunday");
                break;
            default:

                int numberOfEmailToSend = 0;
                long datePercentage = pergentageCalculation(currentDate,
                                                            stop);
                if (countMeet && datePercentage > currentPercentage
                                && datePercentage <= percentage) {
                    break;
                }

                long previous = 0;
                ListIterator<Map.Entry<Long, Integer>> getPergentgeRange = null;
                if (pergentage.size() > 1) {
                    getPergentgeRange = new ArrayList<>(pergentage.entrySet()).listIterator();
                    previous = getPergentgeRange.next().getKey();
                }
                if (firstTime) {
                    assert getPergentgeRange != null;
                    while (getPergentgeRange.hasNext()) {
                        long current = getPergentgeRange.next().getKey();
                        if (datePercentage > current && datePercentage <= previous) {
                            pregentageMeet = true;
                            percentage = (int)previous;
                            numberOfEmailToSend = pergentage.get(previous);
                            processCompleted.put(percentage,
                                                 numberOfEmailToSend);
                            sentCount = 0;
                            countMeet = false;
                            currentPercentage = (int)current;
                            System.out.println(pergentage);
                            equalDaysToSendEmails = (calculateTheDaysForSendingEmails(previous,
                                                                                      current,
                                                                                      todayNumberDays))
                                            / numberOfEmailToSend;
                            pergentage.remove(previous);
                            break;
                        }
                        previous = current;

                    }
                }
                else if (sentCount > count && pergentage.size() > 1) {
                    while (getPergentgeRange.hasNext()) {
                        long current = getPergentgeRange.next().getKey();
                        if (datePercentage > current && datePercentage <= previous) {
                            pregentageMeet = true;
                            percentage = (int)previous;
                            numberOfEmailToSend = pergentage.get(previous);
                            processCompleted.put(percentage,
                                                 numberOfEmailToSend);
                            sentCount = 0;
                            countMeet = false;
                            currentPercentage = (int)current;
                            System.out.println(pergentage);
                            equalDaysToSendEmails = (calculateTheDaysForSendingEmails(previous,
                                                                                      current,
                                                                                      todayNumberDays))
                                            / numberOfEmailToSend;
                            pergentage.remove(previous);
                            skipDaysToMakeEqualDays=0;
                            break;
                        }
                        previous = current;

                    }
                }

                if (pergentage.size() == 1 && countMeet) {
                    for (Map.Entry<Long, Integer> longIntegerEntry : new ArrayList<>(pergentage.entrySet())) {
                        long current = longIntegerEntry.getKey();
                        System.out.println(pergentage);
                        pregentageMeet = true;
                        percentage = (int)current;
                        numberOfEmailToSend = pergentage.get(current);
                        processCompleted.put(percentage,
                                             numberOfEmailToSend);
                        sentCount = 0;
                        countMeet = false;
                        equalDaysToSendEmails = (calculateTheDaysForSendingEmails(current,
                                                                                  0,
                                                                                  todayNumberDays))
                                        / numberOfEmailToSend;

                        pergentage.remove(current);
                        skipDaysToMakeEqualDays=0;
                        break;
                    }
                }

                if (!processCompleted.isEmpty()) {
                    count = processCompleted.get(percentage);
                }

                if (pregentageMeet) {
                    if (skipDaysToMakeEqualDays < equalDaysToSendEmails){
                        skipDaysToMakeEqualDays++;
                        firstTime = false;
                        break;
                    }
                    if (sentCount < count) {
                        System.out.println(String.format("Run the job for the percentage %s", percentage));
                    }
                    sentCount++;
                }

                if (sentCount > count) {
                    countMeet = true;
                    firstTime = false;
                    equalDaysToSendEmails = 0;
                }

                if (skipDaysToMakeEqualDays > equalDaysToSendEmails) {
                    skipDaysToMakeEqualDays = 0;
                }

                if (skipDaysToMakeEqualDays == equalDaysToSendEmails){
                    System.out.println("skipDaysToMakeEqualDays - Count Match for email");
                    emailSendOutMeet = true;
                }
            }
            currentDate = currentDate.plusDays(1);
        }
        return ("Process completed");
    }

    private long calculateTheDaysForSendingEmails (long previous,
                                                   long current,
                                                   long todayNumberDays)
    {
        long days = 0;
        //if (previous != 0 && current != 0) {
            days = ((previous - current) * todayNumberDays) / 100;
        //}
        /*else {
            days = todayNumberDays;
        }*/
        System.out.println(String.format("Number of days for next percentage %s", days));

        return days;
    }

    private long pergentageCalculation (LocalDate currentDate, LocalDate stop)
    {
        LocalDate today = LocalDate.now();
        long totalDays = ChronoUnit.DAYS.between(today,
                                                 stop);
        long elapsedDays = ChronoUnit.DAYS.between(currentDate,
                                                   stop);
        System.out.println(totalDays + " |days >" + elapsedDays);
        todayNumberDays = totalDays;
        return (elapsedDays * 100) / totalDays;
    }

}
