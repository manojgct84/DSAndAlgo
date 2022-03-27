package com.sap.ariba.javaChecks;

public class JavaSwitch
{

    private static final int PasswordResetEmailId = 1;
    private static final int AdminPasswordResetEmailId = 2;
    private static final int WelcomeUserEmailId = 3;
    private static final int UserNameHelpEmailId = 4;
    private static final int EmailChangeEmailId = 5;
    private static final int MULTI_FACT_WELCOME_EMAILID = 6;
    private static final int MULTI_FACT_REMINDER_EMAILID = 7;
    private static final int MULTI_FACT_RESET_EMAILID = 8;

    public static void main (String args[])
    {
        System.out.println("1 " + getNumber(1));
        System.out.println("2 " + getNumber(2));
        System.out.println("5 " + getNumber(5));
        System.out.println("7 " + getNumber(7));

    }

    private static int getNumber (int pageEmailId)
    {
        switch (pageEmailId) {
        case PasswordResetEmailId:
            return 1;
        case AdminPasswordResetEmailId:
            return 2;
        case WelcomeUserEmailId:
            return 3;
        case UserNameHelpEmailId:
            return 4;
        case EmailChangeEmailId:
            return 5;
        case MULTI_FACT_WELCOME_EMAILID:
            return 6;
        case MULTI_FACT_REMINDER_EMAILID:
            return 7;
        case MULTI_FACT_RESET_EMAILID:
            return 8;
        default:
            return 0;

        }

    }
}
