package com.sap.ariba.javaChecks;

public class AuthenticationHandler
{

    public static void main (String[] args)
    {

        Authentication.Builder builder = Authentication.Builder.getInstance();

        //  Authentication.Builder builder = new Authentication.Builder();

        //  Authentication build = new Authentication();

        System.out.println(builder.addlabel("ariba").addSecret("twofactor")
                                           .addProvider("SAP  Ariba:self user@sap.com")
                                           .addLogoPath(null).build().generateQRCode());

        if (builder.build().validateQRCode()) {
            System.out.println("Inside validation");
        }

        /*if (builder == twoFactorAuthentication){
            System.out.println("true");
        }*/
    }
}
