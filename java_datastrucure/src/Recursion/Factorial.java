package Recursion;

public class Factorial {


    public static void main(String[] args) {

        Factorial fac = new Factorial();
        System.out.println(fac.factorial(5));

    }

    public int factorial(int n){
        if (n <= 1){
            return 1;
        }

        return n * factorial(n-1);
    }
}
