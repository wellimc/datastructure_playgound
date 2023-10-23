package Strings;

public class PalindromeNolphaNumeric {


    public static void main(String[] args) {

        String str = "abcdcba";
        System.out.println(isPalindrome(str));

    }

    public  static boolean  isPalindrome(String str ){

        int i = 0;
        int j = str.length() -1;

        while ( i <= j ){
            boolean b = (str.charAt(i) == str.charAt(j));
            if (b == false){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
