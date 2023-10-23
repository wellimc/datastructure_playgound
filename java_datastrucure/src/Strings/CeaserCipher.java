package Strings;

import java.util.HashMap;
import java.util.Map;

public class CeaserCipher {


    public static void main(String[] args) {

        Map letters = getLetterMap();
        letters.forEach((key,value) -> System.out.println(key+ ":" + value) );
        System.out.println(caesarCypherEncryptor("abc",52));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        Map<String, Integer> letters = getLetterMap();
        StringBuilder encrypted = new StringBuilder();

        for(int i=0;i<str.length();i++){
            System.out.println(str.charAt(i));
            Integer keyRef = null;

            if (letters.containsKey(String.valueOf(str.charAt(i)))) {
                keyRef = letters.get(String.valueOf(str.charAt(i)));
            }
            System.out.println(keyRef);

            if ( (keyRef + (key % 26)) > 26){
                int diff =  (keyRef + key) - 26;
                keyRef = diff;
            }else{
                keyRef= keyRef + (key % 26);
            }

            encrypted.append(getLetter(keyRef));
        }

        return encrypted.toString();
    }

    public static String  getLetter(int val) {
        Map<String,Integer> letters = getLetterMap();
        for (String key : letters.keySet()) {
            if (letters.get(key) == val) {
                return key;
            }
        }
        return null;
    }

    public static Map<String,Integer>  getLetterMap() {

    Map<String,Integer> letters = new HashMap<>();
    int i = 1;
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            letters.put(String.valueOf(ch), i);
            i++;
        }

       return letters;
    }
}
