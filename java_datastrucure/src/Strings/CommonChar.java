package Strings;

import javax.xml.stream.events.Characters;
import java.util.*;

public class CommonChar {

    public static void main(String[] args) {
        String[] input = new String[] {"abc","bcb","cbaccd"};

        String[] result = commonCharacters(input);

        System.out.println(Arrays.toString(result));


    }

    public static String[] commonCharacters(String[] strings) {

        Set commonChar = new HashSet<String>();
        String current = strings[0];
        int max = current.length();

        for(int i=0;i<current.length();i++){
            char currentChar = current.charAt(i);
            int j = 1;
            boolean contains = true;
            while (j < strings.length) {
                String toCompare = strings[j];
                if(!containsChar(toCompare,currentChar)){
                    contains = false;
                }
                j++;
            }
            if(contains){
                commonChar.add(String.valueOf(currentChar));
            }
        }
       return (String[]) commonChar.toArray(new String[0]);
    }

    public static boolean containsChar(String s , char search){
        if ( s.length() == 0){
            return false;
        }else{
            return  s.charAt(0) == search || containsChar(s.substring(1),search);
        }
    }

}
