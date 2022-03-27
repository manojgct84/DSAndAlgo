package com.sap.ariba.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PercentageEmailSend implements Callable
{
    private long todayNumberDays = 0;
    private long equalDaysToSendEmails = 0;

    public static void main (String args[]) throws ExecutionException, InterruptedException
    {
        //Executor Service to run it as thread mode.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = new PercentageEmailSend();
        Future<String> future = executor.submit(callable);
        System.out.println(future.get());
        //Executor Service has to be shut down to exit the process
        executor.shutdown();
    }

    @Override
    public Object call () throws Exception
    {

        return jobRun();
    }

    private Object jobRun ()
    {
        LocalDate stop = LocalDate.now().plusDays(80);
        Map<Long, Integer> pergentageMap = new LinkedHashMap<>();
        pergentageMap.put((long)90,
                          1);
        pergentageMap.put((long)75,
                          3);
        pergentageMap.put((long)50,
                          5);
        pergentageMap.put((long)30,
                          10);
        LocalDate currentDate = LocalDate.now();
        long current = 0;
        long previous = 0;
        boolean processIsCompleted = false;
        int numberOfEmailToSend = 0;
        int emailSentToCustomer = 0;
        long skipNumberOfDays = 0;
        int skipCount = 0;
        ListIterator<Map.Entry<Long, Integer>> getPergentgeRange = null;

        getPergentgeRange = new ArrayList<>(pergentageMap.entrySet()).listIterator();
        previous = getPergentgeRange.next().getKey();
        current = getPergentgeRange.next().getKey();
        numberOfEmailToSend = pergentageMap.get(previous);
        pergentageMap.remove(previous);

        for (int i = 0; i < 80; i++) {
            if (processIsCompleted) {
                if (pergentageMap.size() > 1) {
                    getPergentgeRange = new ArrayList<>(pergentageMap.entrySet()).listIterator();
                    previous = getPergentgeRange.next().getKey();
                    current = getPergentgeRange.next().getKey();
                    numberOfEmailToSend = pergentageMap.get(previous);
                    pergentageMap.remove(previous);
                    emailSentToCustomer = 0;
                    processIsCompleted = false;
                }
                else if (pergentageMap.size() == 1) {
                    getPergentgeRange = new ArrayList<>(pergentageMap.entrySet()).listIterator();
                    previous = getPergentgeRange.next().getKey();
                    current = 0;
                    numberOfEmailToSend = pergentageMap.get(previous);
                    pergentageMap.remove(previous);
                    emailSentToCustomer = 0;
                    processIsCompleted = false;
                }
            }
            DayOfWeek day = DayOfWeek.of(currentDate.get(ChronoField.DAY_OF_WEEK));
            switch (day) {
            case SATURDAY:
                System.out.println("Saturday");
                break;
            case SUNDAY:
                System.out.println("Sunday");
                break;
            default:
                long datePercentage = pergentageCalculation(currentDate,
                                                            stop);
                if (!(datePercentage > current && datePercentage <= previous)) {
                    break;
                }
                else {
                    if (emailSentToCustomer >= numberOfEmailToSend) {
                        processIsCompleted = true;
                    }
                    else {
                        skipNumberOfDays = calculateTheDaysForSendingEmails(previous,
                                                                            current,
                                                                            todayNumberDays)
                                        / numberOfEmailToSend;
                        //TODO - This has to be current date.
                        LocalDate daysStillItCanSkip = currentDate.plusDays(skipNumberOfDays);
                        List<LocalDate> localDateList = getListOfDates(currentDate,
                                                                       daysStillItCanSkip);

                        System.out.println("list of dates -> " + localDateList.toString());

                        //TODO - This is only for testing - Start
                        LocalDate dateToSendEmail =
                                        (localDateList.get((int)(localDateList.size()/skipNumberOfDays)));

                        System.out.println("dateToSendEmail >" + dateToSendEmail);
                        //End


                        currentDate = currentDate.plusDays(-skipNumberOfDays);
                        for (int j = 0; j < skipNumberOfDays; j++) {
                            DayOfWeek calcDays =
                                            DayOfWeek.of(currentDate.get(ChronoField.DAY_OF_WEEK));

                            if (!currentDate.equals(daysStillItCanSkip)) {
                                switch (calcDays) {
                                case SATURDAY:
                                    System.out.println("Saturday");
                                    j--;
                                    break;
                                case SUNDAY:
                                    System.out.println("Sunday");
                                    j--;
                                    break;
                                default:
                                    break;
                                }
                                currentDate = currentDate.plusDays(1);
                            } else {
                                System.out.println(String.format("Run the job for the percentage "
                                                                                 + "%s%s",
                                                                 datePercentage,"%s"));
                                emailSentToCustomer++;
                                break;
                            }
                        }
                        System.out.println(String.format("Run the job for the percentage %s%s",
                                                         datePercentage,"%"));
                        emailSentToCustomer++;

                    }

                }

                break;
            }
            currentDate = currentDate.plusDays(1);
        }

        return "Process Completed";
    }

    private List getListOfDates (LocalDate startDate,
                                 LocalDate endDate)
    {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> startDate.plusDays(i)).collect(Collectors.toList());
    }

    private long calculateTheDaysForSendingEmails (long previous,
                                                   long current,
                                                   long todayNumberDays)
    {
        long days = 0;
        days = ((previous - current) * todayNumberDays) / 100;
        //System.out.println(String.format("Number of days for next percentage %s", days));

        return days;
    }

    private long pergentageCalculation (LocalDate currentDate,
                                        LocalDate stop)
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
