package Recursion;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibo(20));
    }

    public static int fibo(int num){

        if ( num == 0){
            return 0;
        }

        if ( num ==1){
            return 0;
        }

        if ( num == 2){
            return 1;
        }

        return fibo(num-1) + fibo(num-2);

    }
}
