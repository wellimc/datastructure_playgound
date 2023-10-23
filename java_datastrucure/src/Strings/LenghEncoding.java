package Strings;

import java.security.spec.RSAOtherPrimeInfo;

public class LenghEncoding {


    public static void main(String[] args) {

        String str = "AAAAAAAAAAAAAAAAAAA";
        System.out.println(runLengthEncoding(str));

    }

    public static String runLengthEncoding(String string) {
        // Write your code here.

        StringBuilder encodedStr = new StringBuilder();
        int j = 0;
        for (int i=0;i<=string.length()-1;i++){
            Character current = string.charAt(i);
            j = 1;
            while (i < string.length()-1 && current.equals(string.charAt(i+1))) {
                i++;
                j++;
            }
            if (j > 9) {
                int diff = Math.abs(j/9);
                System.out.println(diff);
                while (diff >0) {
                    encodedStr.append(9).append(current);
                    System.out.println(encodedStr.toString());
                    diff--;
                }
                if(j%9 != 0) {
                    encodedStr.append(j % 9).append(current);
                }
            } else {
                encodedStr.append(j).append(current);
            }
        }
        return encodedStr.toString();
    }
}
