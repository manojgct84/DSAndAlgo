package com.sap.ariba.javaChecks;

public class Authentication
{
    private String label;
    private String secret;
    private String provider;
    private String logoFilePath;

    private static Authentication authentication;
    private Authentication (Builder builder)
    {
        this.label = builder.label;
        this.provider = builder.provider;
        this.secret = builder.secret;
        this.logoFilePath = builder.logoFilePath;

    }

    public String generateQRCode ()
    {
        System.out.println(label + " : " + provider + " : " + secret + " : " + logoFilePath);

        return "Inside generateQRCode";
    }

    public boolean validateQRCode ()
    {
        return true;
    }

    public static class Builder
    {
        private String label;
        private String secret;
        private String provider;
        private String logoFilePath;
        private static Builder builder;

        private Builder ()
        {
            //empty constructor
        }

        public static Builder getInstance ()
        {
            if (builder == null) {
                builder = new Builder();
            }
            return builder;
        }

        public Builder addlabel (String label)
        {
            this.label = label;
            return this;
        }

        public Builder addSecret (String secret)
        {
            this.secret = secret;
            return this;
        }

        public Builder addProvider (String provider)
        {
            this.provider = provider;
            return this;
        }

        public Builder addLogoPath (String logoFilePath)
        {
            this.logoFilePath = logoFilePath;
            return this;
        }

        public Authentication build ()
        {
            if (authentication == null) {
                authentication = new Authentication(Builder.getInstance());
            }
            return authentication;
        }
    }
}
