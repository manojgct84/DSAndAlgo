package com.leecode.eassy;

public class reserseInt {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }


    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            x = x * -1;
            negative = true;
        }
        int res = 0;
        int result = 0;
        while (x > 0) {
            int r = x % 10;
            result = result * 10 + r;
            if ((result - r) / 10 != res) {
                return 0;
            }
            res = result;
            x /= 10;
        }
        if (negative) {
            res *= -1;
        }
        return res;
    }
}
