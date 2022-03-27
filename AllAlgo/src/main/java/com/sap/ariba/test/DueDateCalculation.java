package com.sap.ariba.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DueDateCalculation implements Runnable
{
    public static void main (String args[])
    {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,
                     60);
        System.out.println(calendar.getTime());
        Date input = calendar.getTime();
        LocalDate feature = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("feature " + feature);
        LocalDate localDate = LocalDate.now();

        long days = ChronoUnit.DAYS.between(localDate,
                                            feature);
        System.out.println("Days " + days);



        Map jsonMap = new LinkedHashMap<>();

        jsonMap.put("notification",
                    "2");
        jsonMap.put("skip",
                    "1");
        jsonMap.put("SetupDate",
                    "13/03/2020");
        jsonMap.put("DueDate",
                    "10/04/2020");
        Long start = System.currentTimeMillis();

        String mapAsString = (String)jsonMap.keySet().stream()
                        .map(key -> key + "=" + jsonMap.get(key)).collect(Collectors.joining(", "));
        System.out.println(mapAsString);

        Long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println("sec " + sec);
        Long start1 = System.currentTimeMillis();
        // mapAsString = null;
        Optional<String> oStr = Optional.of(mapAsString);

        Map<String, String> reconstructedUtilMap = Arrays
                        .stream(oStr.map(value -> value.split(",")).orElse(null))
                        .map(s -> s.split("=",
                                          2)).collect(Collectors.toMap(s -> s[0],
                                                                       s -> s[1]));

        reconstructedUtilMap.put("notification",
                                 String.valueOf(Integer.parseInt(reconstructedUtilMap
                                                                                 .get("notification"))
                                                                + 1));
        System.out.println(reconstructedUtilMap);
        Long end1 = System.currentTimeMillis();
        float sec1 = (end1 - start1) / 1000F;
        System.out.println("sec1 " + sec1);

        Thread thread = new Thread(new DueDateCalculation());
        thread.start();
    }

    @Override
    public void run ()
    {
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < 30; i++) {
            currentDate = currentDate.plusDays(1);
            int frequency = 5;
            if (periodFrequency(currentDate,frequency)) {
                System.out.println("The Schedule Job will run today");
            }
        }
    }

    private boolean periodFrequency (LocalDate currentDate,int frequency)
    {
        //To make the job run based on the perodic frequency
        LocalDate ldt = LocalDate.now().plusDays(30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy",
                                                                  Locale.ENGLISH);
        System.out.println(ldt);
        String date = formatter.format(ldt);
        System.out.println("Formatted Date >> " + date);

       // for (int i = 0; i < 30; i++) {
            System.out.println("currentDate " + currentDate);
            long diffInDays = ChronoUnit.DAYS.between(currentDate,ldt);
            if (diffInDays % frequency == 0) {
                System.out.println("Job will run on this day " + diffInDays / frequency);
                return true;
            }
       // }
        return false;
        //End
    }
}
