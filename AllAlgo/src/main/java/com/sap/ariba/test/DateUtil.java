package com.sap.ariba.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.SimpleFormatter;

class Per
{

    Per ()
    {

    }

    public Per getpeople(){
         return new Per();
    }

}

class People extends Per
{

    People ()
    {

    }
}

public class DateUtil
{

    public static void main (String args[]) throws ParseException
    {
        Per person = new People();

        Per people = person.getpeople();

        SampleCalzz sampleCalzz = new SampleCalzz();

        //sampleCalzz.setPeople(people);

    }
}
