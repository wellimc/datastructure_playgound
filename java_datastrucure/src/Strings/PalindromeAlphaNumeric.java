package Strings;



/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.


 */
public class PalindromeAlphaNumeric {

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    public static boolean  isPalindrome(String s){

        String strAphaNumeric = s.replaceAll("[^a-zA-Z0-9]","").toUpperCase();
        int i = 0;
        int j = strAphaNumeric.length()-1;


        while (j >= 0){
            if(strAphaNumeric.charAt(i) !=  strAphaNumeric.charAt(j)){
                return false;
            }
            j--;i++;

        }
        return true;
    }
}
