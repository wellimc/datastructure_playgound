package Hash.Map;

import java.util.HashMap;

public class CountNames {


    public static void main(String[] args) {
        String[] names = {"alice", "brad", "collin", "brad", "dylan", "kim"};
        HashMap<String,Integer> map = new HashMap<>();

        for (String name : names){
            if(!map.containsKey(name)){
                map.put(name,1);
            }else{
                map.put(name,map.get(name) + 1);
            }
        }
        map.forEach((key,value) -> System.out.println("key :"+key+" value :"+value));
    }


}
