package com.sap.ariba.test;

class GFG
{

    // Function to convert decimal number n
    // to its binary representation
    // stored as an array arr[]
    static void decBinary(int arr[], int n)
    {
        int k = (int)(Math.log(n) /
                        Math.log(2));

        while (n > 0)
        {
            arr[k--] = n % 2;
            n /= 2;
        }
    }

    // Funtion to convert the number
    // represented as a binary array
    // arr[] into its decimal equivalent
    static int binaryDec(int arr[], int n)
    {
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
            ans +=  arr[i] << (arr.length - i - 1);
        return ans;
    }

    // Function to concatenate the binary
    // numbers and return the decimal result
    static int concat(int m,int n)
    {

        // Number of bits in both the numbers
        int k = (int)(Math.log(m) /
                        Math.log(2)) + 1;
        int l = (int)(Math.log(n) /
                        Math.log(2)) + 1;

        // Convert the bits in both the integers
        // to the arrays a[] and b[]
        int a[] = new int[k];
        int b[] = new int[l];

        // c[] will be the binary array
        // for the result
        int c[] = new int[k + l];
        decBinary(a, m);
        decBinary(b, n);

        // Update the c[] array
        int in = 0;
        for (int i = 0; i < k; i++)
            c[in++] = a[i];
        for (int i = 0; i < l; i++)
            c[in++] = b[i];

        // Return the decimal equivalent
        // of the result
        return (binaryDec(c, k + l));
    }

    // Driver code
    public static void main (String[] args)
    {
        int m = 4, n = 80;

        System.out.println(concat(m, n));
    }
}
