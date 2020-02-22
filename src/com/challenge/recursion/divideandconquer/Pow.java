package com.challenge.recursion.divideandconquer;

public class Pow {
    public static double myPow(double x, int n) {

        double temp;
        if (n == 0)
            return 1;
        temp = myPow(x, n / 2);
        if (n % 2 == 0)
            return temp * temp;
        else {
            if (n > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }

        /*if (x == 1 || x == 0) return x;
        if(n == 0) return 1;

        double y = n>0 ? x : 1/x;
        int i = n;
        double z = 1;

       while (true) {
           if (i == 1 || i == -1) break;
           if(i%2 != 0) z *=y;
           y *=y;
           i/=2;
       }

       return y*z;*/
    }


    public static void main(String[] args) {
        System.out.println(myPow(2.0 ,10));
        //System.out.println(myPow(2.00000 ,-2147483648));
        // System.out.println(Math.abs(-2147483648));
    }
}
