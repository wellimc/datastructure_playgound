package Hash.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContansDuplicate {


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
        int[] numsTwice = new int[]{1,2,3,1,2,1};
        System.out.println(containsDuplicateTwice(numsTwice,3));

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numList = new HashSet<Integer>();

        for(int i: nums){
          if(numList.contains(i)){
              return true;
          }else{
              numList.add(i);
          }
        }
        return false;
    }

    public static boolean containsDuplicateTwice(int[] nums,int k) {
        HashMap<Integer,Integer> numList = new HashMap<>();

        for(int i: nums){
            System.out.println("num :"+i);
            if(numList.containsKey(i)){
                if(numList.get(i)+1 >= k){
                    return true;
                }else{
                    numList.put(i,numList.get(i)+1);
                }
            }else{
                numList.put(i,1);
            }

            numList.forEach((key,value)-> System.out.println("key "+key+" value "+value));
            System.out.println("---");
        }
        return false;
    }

}
